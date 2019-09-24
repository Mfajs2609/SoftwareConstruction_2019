package AbstractDataType;

import java.util.Set;


//Genericts
public class TypeTester<T> {



    public static<T> String testType(T t){
        if (t instanceof String){
            return "String";
        } else if (t instanceof Integer){
            return "Integer";
        }else if (t instanceof Boolean){
            return "Boolean";
        }else if (t instanceof Set){
            return "Set";
        }else if (t instanceof Float){
            return "Float";
        }else if (t instanceof Long){
            return "Long";
        }else if (t instanceof  Double){
            return "Double";
        }else{
            return "Object";
        }
    }
}
