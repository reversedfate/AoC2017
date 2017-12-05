fun main(args: Array<String>) {
    var sum = 0;
    var sum2 = 0;
    
    var i = 0;
    while (i<input.length){
        var current = input[i];
        var next = input[(i+1)%input.length];
        var next2 = input[(i+input.length/2)%input.length];
        
		if (current==next){
            sum+=current.toInt()-'0'.toInt();
        }
        if (current==next2){
            sum2+=current.toInt()-'0'.toInt();
        }
  		i++;
    }
    println(sum);
    println(sum2); 
}
