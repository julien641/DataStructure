
public class objectbnode
{

    objectbnode  nodenumber;   //Record or Node number IDentifier
    int  info;         //Any information fields
    objectbnode  flink;        //forward link, if used, to next record
    objectbnode  blink;        //backward link, if used, to previous record
    objectbnode  parent;       //parent link, if used, for a binary tree
    objectbnode  lchild;       //left child, if used, for a binary tree
    objectbnode  rchild;       //right child, if used, for a binary tree
     

public objectbnode() {  // The no-arg constructor 
flink=null;
blink=null;
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

int setNodeNumber(objectbnode  n)
{
    nodenumber = n;
    return 0;
}

objectbnode getNodeNumber()
{
    return nodenumber;
}

int setFlink(objectbnode  n)
{
    flink = n;
    return 0;
}

int setBlink(objectbnode  n)
{
    blink = n;
    return 0;
}

objectbnode getFlink()
{
    return flink;
}

objectbnode getBlink()
{
    return blink;
}

}  //End of Class