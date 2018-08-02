package mypackage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.*;

public class Entity_vote {
    public static void find_entity(String result,ArrayList entitys)
    {
        for(int i=0;i<result.length();i++)
        {
            char now_char=result.charAt(i);
            int start=-1;
            int end=-1;
            if(now_char=='B')
            {
                start=i;
                for(int j=i;j<result.length();j++)
                {
                    if(result.charAt(j)=='I')
                    {
                        continue;
                    }
                    if(result.charAt(j)=='E')
                    {
                        end=j;
                        i=j;
                        Entity_info nowentity=new Entity_info(result.substring(start,end+1),start,end);
                        entitys.add(nowentity);
                        break;
                    }
                }
            }
        }

    }
    public static ArrayList ensemble(ArrayList<ArrayList> entity_matrix,int mode,double []confidence)
    {

        HashSet allset=new HashSet();//所有非重复实体并集
        Iterator classifier_itor=entity_matrix.iterator();
        while (classifier_itor.hasNext())
        {
            allset.addAll((ArrayList)classifier_itor.next());
        }
        ArrayList all_list=new ArrayList(allset);
        Comparator cmp=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Entity_info a=(Entity_info)o1;
                Entity_info b=(Entity_info)o2;
                if(a.getStrat()<b.getStrat())
                {
                    return -1;
                }
                else if(a.getStrat()>b.getStrat())
                {
                    return 1;
                }
                else if(a.getEnd()<b.getEnd())
                {
                    return -1;
                }
                else return 1;
            }
        };
        Collections.sort(all_list,cmp);

        //Pooling mode  If entity_matrix: [[x1, x2, x3], [x1, x3, x4], [x1, x2]]
        //Then the result is: [x1, x2, x3, x4].
        if(mode==1)
        {
            return all_list;
        }
        //MajorityVote
        //If entity_matrix: [[x1, x2, x3], [x1, x3, x4], [x1, x2]]
        //Then the result is: [x1, x2, x3] because these entities have
        //been annotated by 2/3 of the NER models.
        if(mode==2)
        {
            ArrayList result_list=new ArrayList();
            double [][]Vote_score=new double[entity_matrix.size()][all_list.size()];
            int row_vote=0;
            int col_vote=0;
            classifier_itor=entity_matrix.iterator();
            while (classifier_itor.hasNext())
            {
                ArrayList now_classifier= (ArrayList)classifier_itor.next();
                Iterator entity_it=all_list.iterator();
                col_vote=0;
                while (entity_it.hasNext())
                {
                    Entity_info now_entity=(Entity_info)entity_it.next();
                    if(now_classifier.contains(now_entity))
                    {
                        Vote_score[row_vote][col_vote]=1;
                    }
                    else
                    {
                        Vote_score[row_vote][col_vote]=0;
                    }
                    col_vote++;
                }
                row_vote++;
            }
            for(int j=0;j<all_list.size();j++)
            {
                int total_voted=0;
                for(int i=0;i<entity_matrix.size();i++)
                {
                    if(Vote_score[i][j]==1)
                    {
                        total_voted++;
                    }
                }
                if(total_voted>=(entity_matrix.size()+1)/2)
                {
                    result_list.add(all_list.get(j));
                }
            }
            return result_list;
        }
        else {
            double[] weight_matrix = new double[confidence.length];
            double sum = 0;

            for (int i = 0; i < confidence.length; i++) {
                sum += confidence[i];
            }
            for (int i = 0; i < confidence.length; i++) {
                weight_matrix[i] = confidence[i] / sum;
            }
            ArrayList result_list = new ArrayList();
            double[][] Vote_score = new double[entity_matrix.size()][all_list.size()];
            int row_vote = 0;
            int col_vote = 0;
            classifier_itor = entity_matrix.iterator();
            while (classifier_itor.hasNext()) {
                ArrayList now_classifier = (ArrayList) classifier_itor.next();
                Iterator entity_it = all_list.iterator();
                col_vote = 0;
                while (entity_it.hasNext()) {
                    Entity_info now_entity = (Entity_info) entity_it.next();
                    if (now_classifier.contains(now_entity)) {
                        Vote_score[row_vote][col_vote] = 1;
                    } else {
                        Vote_score[row_vote][col_vote] = 0;
                    }
                    col_vote++;
                }
                row_vote++;
            }
            for (int j = 0; j < all_list.size(); j++) {
                double total_voted = 0;
                for (int i = 0; i < entity_matrix.size(); i++) {
                    if (Vote_score[i][j] == 1) {
                        total_voted+=Vote_score[i][j]*weight_matrix[j];
                    }
                }
                DecimalFormat df = new DecimalFormat("#.##");
                total_voted=Double.parseDouble(df.format(total_voted));
                if (total_voted>0.5) {
                    result_list.add(all_list.get(j));
                }
            }
            return result_list;
        }
    }
    public static void main(String args[])
    {

        //测试样例
        //3
        //B E O O B I I I E O O O O B I I I I E O O O B I I I I E O O O B I I I I E O O B I I I E O O O O O O B E O B I E
        //O O O O O B I I I I E O B I I E O B E O O O B I E B I E O O O O B I E O O O O O O O O O O B E O O B I I I I I E
        //E O O B I I I E O O O B I I E O B E O O O B I I I I E O O B I I I E O O O O B I I I E O O O O O O B E O B I E
        Scanner sc=new Scanner(System.in);
        int classifer_num=sc.nextInt();//分类器个数
        double []confidence={0.85,0.75,0.67};
        sc.nextLine();
        String []bio_results=new String[classifer_num];
        ArrayList<ArrayList> entity_matrix=new ArrayList<>();//总结果矩阵
        for(int i=0;i<classifer_num;i++)
        {
            bio_results[i]=sc.nextLine().replace(" ","");
            ArrayList nowvote=new ArrayList();
            find_entity(bio_results[i],nowvote);
            entity_matrix.add(nowvote);
        }
        ArrayList result=ensemble(entity_matrix,3,confidence);

    }

}
