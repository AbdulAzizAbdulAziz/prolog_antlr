import java.util.ArrayList;
import java.util.HashMap;

public class actions 
{
    static HashMap<String,ArrayList<ArrayList<String>>> fax = new HashMap<String,ArrayList<ArrayList<String>>>();

    static void gen_fax(String S)
    {
        if(fax.containsKey(S))
        {return;}
        else
        fax.put(S, new ArrayList<ArrayList<String>>());
    }

    static void push_fax(String fact,ArrayList<String> things)
    {
        fax.get(fact).add(things);
    }

    static void quer(String fact,ArrayList<String> querry)
    {
        boolean nu=false;
        Object[] copy=querry.toArray();

        System.out.println("query: "+fact+querry.toString());
        
        if (!(fax.containsKey(fact))){System.out.println("NO!"+'\n');}

        ArrayList<ArrayList<String>> a=fax.get(fact);

        for (int i=0;i<a.size();i++)
        {
            boolean match=false;
            boolean varmatch=false;

            if(a.get(i).size()!=querry.size()){continue;}
            
            ArrayList<Integer> temp= new ArrayList<>();

            for(int j=0;j<a.get(i).size();j++)
            {
                if('A'<=querry.get(j).charAt(0)&&'Z'>=querry.get(j).charAt(0))
                {
                    varmatch=true;
                    querry.set(j,a.get(i).get(j));
                    temp.add(j);
                }
            }

            if (a.get(i).equals(querry))
            {
                match=true;
                nu=true;
                System.out.println("Match: "+fact+a.get(i).toString());
            }
            for(int j=0;j<temp.size();j++)
            {
                if(varmatch&&match)
                {
                    System.out.println(copy[temp.get(j)].toString()+'='+querry.get(temp.get(j)));
                }
                querry.set(temp.get(j),querry.get(temp.get(j)).toUpperCase());
            }
        }
        if(!nu)
        {
            System.out.println("NO!");
        }
        else
        {
            System.out.println("Yes!");
        }
        System.out.println();
    }
}