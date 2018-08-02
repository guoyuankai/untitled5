import java.math.BigDecimal;
import java.util.Scanner;

public class Back_process {
    /*请完成下面的函数，实现题目要求的功能
   当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
   ******************************开始写代码******************************/
    static double sigmoid(double x){
        return 1.0 / (1.0 + Math.pow(Math.E, -x));
    }

    /*sigmoid的导数*/
    static double dsigmoid(double y){
        return y * (1 - y);
    }

    static double[] bpnn(int N, int I, int H, int O, int[][] inputs, int[][] targets) {
        double [][]weight_input_hidden=new double[1+I][H];
        double [][]weight_hidden_out=new double[H][O];
        double []hidden_unit_in=new double[H];
        double []hidden_unit_out=new double[H];
        double []predict_in=new double[O];
        double []predict_out=new double[O];
        double []loss=new double[N];

        for(int i=0;i<N;i++)
        {
            //正向传播输入到隐层
            for(int j=0;j<H;j++)
            {
                for(int k=0;k<I;k++)
                {
                    hidden_unit_in[j]+=inputs[i][k]*weight_input_hidden[k][j];
                }
                hidden_unit_in[j]+=1.0*weight_input_hidden[I][j];
                hidden_unit_out[j]=sigmoid(hidden_unit_in[j]);
            }
            //正向传播隐层到输出
            for(int n_out=0;n_out<O;n_out++)
            {
                for(int n_hidden=0;n_hidden<H;n_hidden++)
                {
                    predict_in[n_out]+=hidden_unit_out[n_hidden]*weight_hidden_out[n_hidden][n_out];
                }
                predict_out[n_out]=sigmoid(predict_in[n_out]);
            }

            //误差计算
            double nowloss=0;
            for(int n_out=0;n_out<O;n_out++)
            {
                double temp_loss=targets[i][n_out]-predict_out[n_out];
                nowloss+=0.5*Math.pow(temp_loss,2);
            }
            BigDecimal b   =   new   BigDecimal(nowloss);
            double   f1   =   b.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();
            loss[i]=nowloss;

            //反向传播  输出到隐层
            double []predict_true_to_out=new double[O];
            double []predict_out_to_in=new double[O];
            double [][]final_step_out_to_hidden=new double[H][O];
            for(int n_out=0;n_out<O;n_out++)
            {
                predict_true_to_out[n_out]=predict_out[n_out]-targets[i][n_out];
                predict_out_to_in[n_out]=dsigmoid(predict_out[n_out]);
                for(int n_hidden=0;n_hidden<H;n_hidden++)
                {
                    double predict_in_to_hiddenout=hidden_unit_out[n_hidden];
                    double final_step=predict_true_to_out[n_out]*predict_out_to_in[n_out]*predict_in_to_hiddenout;
                    final_step_out_to_hidden[n_hidden][n_out]=0.5*final_step;
                    //weight_hidden_out[n_hidden][n_out]-=0.5*final_step;

                }

            }
            double []total_to_hidden=new double[H];
            for(int n_hidden=0;n_hidden<H;n_hidden++)
            {
                for(int n_out=0;n_out<O;n_out++)
                {
                    total_to_hidden[n_hidden]+=predict_true_to_out[n_out]*predict_out_to_in[n_out]*weight_hidden_out[n_hidden][n_out];
                }
            }

            //反向传播  隐层到输入
            double [][]final_step_hidden_to_in=new double[I+1][H];

            for(int n_hidden=0;n_hidden<H;n_hidden++)
            {
                double hiddenout_to_in=dsigmoid(hidden_unit_out[n_hidden]);
                for(int n_in=0;n_in<I;n_in++)
                {
                    double hiddenin_to_in=inputs[i][n_in];
                    double final_step=total_to_hidden[n_hidden]*hiddenout_to_in*hiddenin_to_in;
                    final_step_hidden_to_in[n_in][n_hidden]=0.5*final_step;
                    //weight_input_hidden[n_in][n_hidden]-=0.5*final_step;
                }
                double final_bias_sgd=hiddenout_to_in*1*total_to_hidden[n_hidden];
                final_step_hidden_to_in[I][n_hidden]=0.5*final_bias_sgd;
                //weight_input_hidden[I][n_hidden]-=0.5*(final_bias_sgd);
            }





            for(int n_in=0;n_in<=I;n_in++)
            {
                for(int n_hidden=0;n_hidden<H;n_hidden++)
                {
                    weight_input_hidden[n_in][n_hidden]-=final_step_hidden_to_in[n_in][n_hidden];
                }
            }
            for(int n_hidden=0;n_hidden<H;n_hidden++)
            {
                for(int n_out=0;n_out<O;n_out++)
                {
                    weight_hidden_out[n_hidden][n_out]-=final_step_out_to_hidden[n_hidden][n_out];
                }
            }





        }
        return loss;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in

        );
        double[] res;

        int _N;
        _N = in.nextInt();

        int _I;
        _I =  in.nextInt();

        int _H;
        _H =  in.nextInt();

        int _O;
        _O =  in.nextInt();

        int[][] _inputs = new int[_N][_I];
        int[][] _targets = new int[_N][_O];
        for(int i=0; i<_N; i++) {
            for(int j=0; j<_I; j++) {
                _inputs[i][j] = in.nextInt();
            }
            for(int j=0; j<_O; j++) {
                _targets[i][j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = bpnn(_N, _I, _H, _O, _inputs, _targets);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
