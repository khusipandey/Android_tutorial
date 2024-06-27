fun main() {
  var num=153   //3 digit number
  var temp=num
  var rem=0
  var sum=0
    while (temp>0)
    {
        rem=temp%10
        sum=sum+(rem*rem*rem)
        temp=temp/10
    }
    if(num==sum)
    {
        println("armstrong")
    }
    else
    {
        println("not an armstrong number")
    }
}
