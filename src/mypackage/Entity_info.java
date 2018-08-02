package mypackage;

public class Entity_info {
    private String entity;
    private int strat;
    private int end;
    public Entity_info(String entity,int start,int end)
    {
        this.entity=entity;
        this.strat=start;
        this.end=end;
    }
    public int getStrat()
    {
        return this.strat;
    }
    public  int getEnd()
    {
        return this.end;
    }
    public String getEntity()
    {
        return this.entity;
    }
    //重写equal 和hascode 方法，保证泛型判定重复正确
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity_info)) return false;

        Entity_info that = (Entity_info) o;

        if (strat != that.strat) return false;
        if (end != that.end) return false;
        return entity != null ? entity.equals(that.entity) : that.entity == null;
    }

    @Override
    public int hashCode() {
        int result = entity != null ? entity.hashCode() : 0;
        result = 31 * result + strat;
        result = 31 * result + end;
        return result;
    }

}
