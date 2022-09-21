package Trie;
public class Node {
    public Node[] links = new Node[26];
    public int ctrEndWith;
    public int ctrPrefix;
    public boolean flag;

        boolean containsKey(char ch)
        {
            return (links[ch-'a']!=null);
        }

        Node get(char ch)
        {
            return links[ch-'a'];
        }

        void put(char ch,Node node)
        {
            links[ch-'a']=node;
        }

        void increaseEnd()
        {
            ctrEndWith++;
        }

        void increasePrefix()
        {
            ctrPrefix++;
        }

        void deleteEnd()
        {
            ctrEndWith--;
        }

        void reducePrefix()
        {
            ctrPrefix--;
        }

        int getEnd()
        {
            return ctrEndWith;
        }

        int getPrefix()
        {
            return ctrPrefix;
        }

        void setEnd()
        {
            flag=true;
        }

        boolean isEnd()
        {
            return flag;
        }
}    