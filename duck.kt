fun main() {
    var num= 1304
    var d: Int
    var c=0
    while(num>0)
    {
        d=num%10
        if(d==0)
        {
            c++
        }
        num=num/10
    }
    if(c==0)
    {
        println("not a duck")
    }
    else
    {
        println("duck number")
    }
   
}
