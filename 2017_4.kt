fun main(args: Array<String>) {
	var valid = 0;
    var valid2 = 0;
    var i = 0;
    while (i<input.size){
        if (checkPhrase(input[i])) valid++;
        if (checkPhrase2(input[i])) valid2++;
        i++;
    }
    
    println(valid);
    println(valid2);
}

fun checkPhrase(line : String) : Boolean{
    var array = line.split(" ");
    var valid = true;
    
    var i = 0;
    while (i<array.size){
        if (array.count({st -> st == array[i]}) > 1) valid = false;
        i++;
    }
    
    return valid;
}

fun checkPhrase2(line : String) : Boolean{
    var array = line.split(" ");
    var valid = true;
    
    var i = 0;
    while (i<array.size){
        if (array.count({st -> var a : Array<String> = st.split("").toTypedArray();
                               var b : Array<String> = array[i].split("").toTypedArray();
                         	   a.sort();
                         	   b.sort();
                        	   a contentDeepEquals b}) > 1) valid = false;
        i++;
    }
    
    return valid;
}
