package tag04.aufgaben.loesung;

public class Pair<A, B>
{
    private A value0;
    private B value1;

    public A getValue0()
    {
        return value0;
    }

    public void setValue0(A value0)
    {
        this.value0 = value0;
    }

    public B getValue1()
    {
        return value1;
    }

    public void setValue1(B value1)
    {
        this.value1 = value1;
    }

    public Object[] toArray()
    {
        return new Object[] {value0, value1};
    }

    public static <A, B> Pair<A, B> of(A value0, B value1)
    {
        Pair<A, B> p = new Pair<>();
        p.value0 = value0;
        p.value1 = value1;

        return p;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", value0, value1);
    }
}
