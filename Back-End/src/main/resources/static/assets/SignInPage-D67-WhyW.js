import{j as t,F as p,c as o,a as i,A as s}from"./index-wnN-NG7C.js";import{B as d,u as m,S as h,C as u}from"./Button-DLNhRGbV.js";const x=({type:e})=>t(p,{children:e==="SMALL"?t(b,{src:"/img/cits_logo.png",alt:"logo"}):t(f,{src:"/img/cits_logo.png",alt:"logo"})}),b=o("img",{target:"e1mjj7jf1"})({name:"1ut6ymr",styles:"height:60px"}),f=o("img",{target:"e1mjj7jf0"})({name:"1jhcz1g",styles:"width:270px"}),c=o("input",{target:"eb8zv6k2"})({name:"vz01ff",styles:"background-color:white;width:220px;height:45px;border:0px white solid;border-left:5px white solid;border-radius:3px;outline:none;margin-top:10px;font-size:15px"}),y=o(d,{target:"eb8zv6k1"})({name:"vq7e75",styles:"font-size:17px;font-weight:bold;width:230px;height:45px;background-color:#2528c7;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:10px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#2528c7;border:0px;box-shadow:0 0 0 0 black;margin-top:15px;margin-bottom:0px;transition:0s;}"}),w=o("form",{target:"eb8zv6k0"})({name:"c6kwia",styles:"width:20%;aspect-ratio:1;z-index:2;display:flex;flex-direction:column;justify-content:center;align-items:center"}),I=()=>{const{register:e,handleSubmit:l}=m({defaultValues:{signId:"",password:""}}),g=async n=>{try{const r=await s.post("/auth/login",n),{token:a}=r.data;localStorage.setItem("authToken",a),s.defaults.headers.common.Authorization=`Bearer ${a}`}catch(r){console.error("Login error:",r)}};return i(u,{children:[t(x,{type:"BIG"}),t(h,{children:i(w,{onSubmit:l(n=>{g(n)}),children:[t(c,{placeholder:"아이디",...e("signId",{required:"아이디를 입력해주세요!"})}),t(c,{placeholder:"비밀번호",type:"password",...e("password",{required:"비밀번호를 입력해주세요!"})}),t(y,{type:"submit",variant:"contained",children:"로그인"})]})})]})};export{I as default};
