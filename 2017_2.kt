fun main(args: Array<String>) {
    var sum = 0;
    var sum2 = 0;
    
    var i = 0;
    while (i<input.size){
        //part 1
        var array = input[i].split("	");
        
        var min = array[0].toInt();
        var max = array[0].toInt();
        
        var j = 0;
        while (j<array.size){
            var current = array[j].toInt();
            if (current<min) {
                min = array[i].toInt();
            }
            if (current>max) {
                max = array[i].toInt();
            }
            j++;
        }
        
        sum += max-min;
        
		//part 2        
        var div = findDiv(array);
        sum2 += div;
        
        i++;
    }
    
    println(sum);
	println(sum2);
}

fun findMin(array: Array<String>) : Int{
    var min = array[0].toInt();
    var j = 0;
        while (j<array.size){
            var current = array[j].toInt();
            if (current<min) {
                min = array[j].toInt();
            }
            j++;
        }
    return min;
}

fun findMax(array: Array<String>) : Int{
    var max = array[0].toInt();
    var j = 0;
        while (j<array.size){
            var current = array[j].toInt();
            if (current>max) {
                max = array[j].toInt();
            }
            j++;
        }
    return max;
} 

fun findDiv(array: List<String>) : Int{
    var div = 0;
    var i = 0;
    while (i<array.size){
       	var ci = array[i].toInt();
        var j = 0;
        while (j<array.size){
            if (i!=j){
            	var cj = array[j].toInt();
        		if (divides(ci,cj)) {div = cj/ci; println("" + ci + " divides " + cj + ", division is " + div)};
            	if (divides(cj,ci)) {div = ci/cj; println("" + cj + " divides " + ci + ", division is " + div)};
            }
        	j++;
    	}
        i++;
    }
    
    return div;
} 

fun divides(a : Int, b : Int) : Boolean {
    return (b/a)*a == b;
}
