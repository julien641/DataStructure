
public class node
{

    node  nodenumber;   //Record or Node number IDentifier
    int  info;         //Any information fields
    node  flink;        //forward link, if used, to next record
    node  blink;        //backward link, if used, to previous record
    node  parent;       //parent link, if used, for a binary tree
    node  lchild;       //left child, if used, for a binary tree
    node  rchild;       //right child, if used, for a binary tree
     

public node() {  // The no-arg constructor 
flink=null;
blink=null;
rchild=null;
lchild=null;
parent=null;
}

int setInfo(int  x)
{
    info = x;
    return 0;
}

int getInfo()
{
    return info;
}

int setNodeNumber(node  n)
{
    nodenumber = n;
    return 0;
}

node getNodeNumber()
{
    return nodenumber;
}

int setFlink(node  n)
{
    flink = n;
    return 0;
}

int setBlink(node  n)
{
    blink = n;
    return 0;
}

node getFlink()
{
    return flink;
}

node getBlink()
{
    return blink;
}

}  //End of Class