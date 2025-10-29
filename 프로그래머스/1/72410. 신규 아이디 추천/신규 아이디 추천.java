class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 아이디의 길이는 3자 이상 15자 이하여야 합니다.
        // 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
        // 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
        
        new_id = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        boolean isDot = false;
        
        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if(Character.isDigit(c)){
                sb.append(c);
                isDot = false;
            } else if(Character.isLowerCase(c)){
                sb.append(c);
                isDot = false;
            } else if(c == '-' || c == '_'){
                sb.append(c);
                isDot = false;
            } else if(c == '.'){
                // 이전 문자가 마침표였으면 패스
                if(isDot){
                    continue;
                } else if(i == 0 || i == new_id.length() - 1){
                    // 아니었더라도 첫번째나 마지막 문자였다면 패스
                    isDot = true;
                } else {
                    isDot = true;
                    sb.append(c);
                }
            }
        }
        
        String str = sb.toString();
        
        // 뒤에 있는 . 빼기
        while(str.length() != 0){
            if(str.charAt(str.length() - 1) == '.'){
                str = str.substring(0, str.length() - 1);
            } else {
                break;
            }
        }

        // 앞에 있는 . 빼기
        while(str.length() != 0){
            if(str.charAt(0) == '.'){
                str = str.substring(1, str.length());
            } else {
                break;
            }
        }
        
        
        if(str.length() == 0){
            str += "a";
        }
        
        while(!(str.length() >= 3 && str.length() <= 15)){
            if(str.length() < 3){
                char c = str.charAt(str.length() - 1);
                str += c;
            } else if(str.length() > 15){
                str = str.substring(0, 15);
            }
        }
        
        // 뒤에 있는 . 빼기
        while(str.length() != 0){
            if(str.charAt(str.length() - 1) == '.'){
                str = str.substring(0, str.length() - 1);
            } else {
                break;
            }
        }
        
        while(!(str.length() >= 3 && str.length() <= 15)){
            if(str.length() < 3){
                char c = str.charAt(str.length() - 1);
                str += c;
            } else if(str.length() > 15){
                str = str.substring(0, 15);
            }
        }
        
        
        System.out.println(str);
        
        return str;
    }
}