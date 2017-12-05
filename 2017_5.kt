fun main(args: Array<String>) {
    var x = 0;
    var steps = 0;
    while (!isOutside(x)){
        var moveThisMuch = input[x].toInt();
        //if (moveThisMuch<3){ //enable commented lines for part 2
            input[x] = (moveThisMuch+1).toString();  
        //}else{
        //	input[x] = (moveThisMuch-1).toString();
        //}
        
        x += moveThisMuch;
        steps++;
    }
 	println(steps);    
}

fun isOutside(x : Int) : Boolean {
    if (x<0 || x>=input.size) return true;
    return false;
}
