fun main(args: Array<String>) {
	var x : Long = 0;
    var y : Long = 0;
    var result2 : Long = 0;
    
	var target = input.toLong();
    //target = 9;
    var current = 1;
    var direction = 0;
    var turns = 0;
    var steps = 0;
    var currentLength = 1;
    var debug = false;
    
    var mapOfValues = mutableMapOf<String, Long>();
    mapOfValues["0,0"] = 1;
    
    while (current < target){
        if (debug) println("current:"+current);
        
        if (result2 == 0L) {
            if (debug) println("	performing sum calculation...");
            var cellSum = sumAllKnownNeighbours(x,y, mapOfValues);
            if (debug) println("	current cell sum: " + cellSum);
            if (cellSum>target) {
                if (debug) println("	cellsum was larger than "+target+"!");
                result2 = cellSum;
            }
            var key = ""+x+","+y;
            if (!mapOfValues.containsKey(key)) {
                if (debug) println("	adding "+cellSum+" to ["+key+"]");
                mapOfValues[key] = cellSum;
            }
        }
        
        if (debug) println("	x:" + x + ";y:" + y + ",direction:"+direction);
		//turn if needed
        if (steps==currentLength){
            if (debug) println("	turning...")
            direction = (direction+90)%360;
            turns++;
            currentLength = turns/2+1;
            steps=0;
            if (debug) println("	x:" + x + ";y:" + y + ",direction:"+direction);
        }
		//step forward        
		if (debug) println("	stepping...")
		if (direction==0){x++;}
        if (direction==90){y++;}
        if (direction==180){x--;}
        if (direction==270){y--;}
        if (debug) println("	x:" + x + ";y:" + y + ",direction:"+direction);
        steps++;
        current++;
    }
    
    println(abs(x)+abs(y));
	println(result2);   
    
}

fun abs(x : Long) : Long{
	if (x>0) return x;
    return -x;
}

fun sumAllKnownNeighbours(x : Long,y : Long, mapOfValues : Map<String,Long>) : Long{
    var sum : Long = 0;
    var xoff = -1;
    while (xoff<=1){
    	var yoff = -1;
        while (yoff<=1){
            if (yoff!=0 || xoff!=0){
                var key = ""+(x+xoff)+","+(y+yoff);
                if (mapOfValues.containsKey(key)) sum += mapOfValues[key]!!.toLong();
            }
            yoff++;
        }
        xoff++;
    }
    return sum;
}
