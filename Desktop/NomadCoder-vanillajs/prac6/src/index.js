const loginForm = document.querySelector("#loginForm");
const email = document.querySelector("#email");
const password = document.querySelector("#password");
const loginBtn = document.querySelector(".input-group button");

function clickLogin(){

   let emailInfo = email.value;
   let passwordInfo = password.value;

    if(emailInfo == "" || passwordInfo == "" ){
        window.alert("이메일 혹은 비밀번호가 입력되지 않았습니다.");
    }else{
        if(emailConfirm(true) || passwordConfirm(true) )
        
        window.alert("로그인 완료!");
        
    }  



function emailConfirm(){
    let emailInfoCon = email.value;
    emailInfoCon= "/^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z0-9]{1,3}$/";
        
        if(emailInfoCon){
            return true;
        }
        else{
        window.alert("이메일 형식이 올바르지 않습니다.");
        return false;
        }
 }
 
 function passwordConfirm(){
     let passwordInfo = password.value;
     if(passwordInfo.length>= 8 && passwordInfo.length<=20){
         let num = passwordInfo.search(/[0-9]/g);
         let eng = passwordInfo.search(/[a-z]/ig);
         let spe = passwordInfo.search(/[!@~]/gi);
         if(!(num =="" || eng =="" ||spe=="")){
         window.alert("비밀번호는 영문, 숫자, 특수문자를 모두 포함해야 합니다.");
         }
 
     }else{
         window.alert("비밀번호는 최소 8자 이상, 최대 20자 이하로 구성해야 합니다.");
     }
  return true;
 }
 }
 loginForm.addEventListener("submit",clickLogin);



    