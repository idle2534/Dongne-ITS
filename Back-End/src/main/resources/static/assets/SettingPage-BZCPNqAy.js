import{r as m,a as N,d as R,u as P,b as h,j as e,P as V,F as v,e as T,c as s}from"./index-gLocR9Ls.js";import{u as E,B as j,C as q}from"./Button-BXdxjecy.js";import{E as L,S as M,a as $,b as C,G as A}from"./StatusMessage-C2buAyQs.js";import{P as z,A as k,d as F}from"./Backspace-CGu7MxSD.js";const O=()=>{const[i,a]=m.useState(!1),d=N(),u=R(t=>t.projects),p=P(t=>t.isAdmin),{loadAllProjectList:r}=z();return m.useEffect(()=>{r()},[]),h(v,{children:[i&&e(H,{onClose:()=>{a(!1)}}),e(M,{title:"프로젝트",createClick:p()?()=>{a(!0)}:void 0,children:u.map(t=>e(L,{onClick:()=>{d(V.Project,{state:{id:t.id}})},children:`${t.name} [${t.id}]`},t.id))})]})},H=({onClose:i})=>{const{handleSubmit:a,register:d}=E(),[u,p]=m.useState(!1),[r,t]=m.useState([]),[b,f]=m.useState([]),o=m.useRef(!1),n=T(l=>l.accounts),{loadAllAccountList:w}=k(),{addProject:x}=z();m.useEffect(()=>{w()},[]),m.useEffect(()=>{const l=[];o.current?n.map(c=>{c.role!=="PL"&&l.push({value:c.id,label:`${c.name} [${c.role}] [${c.id}]`})}):n.map(c=>{l.push({value:c.id,label:`${c.name} [${c.role}] [${c.id}]`})}),f(l)},[n,o.current]);const B=l=>{if(!l.name){p("모든 정보를 입력해주세요.");return}x({name:l.name,memberIds:r}),i()},I=l=>{var c;if((c=b.find(g=>`${g.value}`===l))!=null&&c.label.includes("PL")&&(o.current=!0),r.findIndex(g=>`${g}`===l)===-1){const g=[...r];g.push(`${l}`.match(/\d+/g).map(Number)[0]),t(g)}};return h(A,{onClose:i,children:[u?e($,{message:u,setMessage:p,duration:2e3}):null,h(U,{onSubmit:a(B),children:[e(G,{children:"프로젝트 생성"}),e(_,{placeholder:"프로젝트 이름",...d("name")}),e(C,{options:b,onChange:I,placeholder:"프로젝트 담당자 설정 선택"}),e(J,{children:e(K,{children:r.map((l,c)=>{const g=n.find(S=>S.id===l);return e("div",{children:g?h(W,{children:[`${g.name} (${g.role})`,e(Q,{onClick:()=>{g.role==="PL"&&(o.current=!1);const S=[...r];S.splice(c,1),t(S)}})]}):null},l)})})}),e(X,{type:"submit",variant:"contained",children:"등록하기"})]})]})},G=s("div",{target:"e1epv5x57"})({name:"1n5m32i",styles:"font-size:35px;font-weight:bold;color:#2528c7;margin-bottom:-8px"}),U=s("form",{target:"e1epv5x56"})({name:"k27csg",styles:"width:100%;display:flex;flex-direction:column;justify-content:center;align-items:center"}),_=s("input",{target:"e1epv5x55"})({name:"17lqpmn",styles:'background-color:white;width:80%;height:45px;border:2px solid #5d5dff;border-radius:3px;outline:none;margin-top:20px;font-size:16px;text-align:center;font-family:"Spoqa Han Sans Neo","sans-seri";::placeholder{font-family:"Spoqa Han Sans Neo","sans-seri";text-align:center;}'}),J=s("div",{target:"e1epv5x54"})({name:"1fmeecv",styles:"position:relative;background-color:white;width:80%;height:170px;background-color:#5d5dff;border:3.5px solid #5d5dff;margin-left:15px;margin-right:15px;margin-top:10px;border-radius:3px;overflow-y:auto;::-webkit-scrollbar{width:6px;}::-webkit-scrollbar-thumb{background-color:#2f3542;}::-webkit-scrollbar-track{background-color:#dcdcdc;}"}),K=s("div",{target:"e1epv5x53"})({name:"a1snif",styles:"width:100%;display:flex;align-items:center;flex-direction:column"}),Q=s(F,{target:"e1epv5x52"})({name:"anun7w",styles:"position:absolute;right:10px"}),W=s("div",{target:"e1epv5x51"})({name:"ssiio0",styles:"position:relative;background-color:white;width:330px;height:40px;border-radius:3px;margin-top:8px;margin-bottom:3px;color:#5d5dff;font-size:16px;display:flex;align-items:center;justify-content:center"}),X=s(j,{target:"e1epv5x50"})({name:"t0juvn",styles:"font-size:17px;font-weight:bold;width:82%;height:50px;background-color:#2528c7;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:20px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#2528c7;border:0px;box-shadow:0 0 0 0 black;margin-top:25px;margin-bottom:0px;transition:0s;}"}),Y=()=>{const{loadAllAccountList:i}=k(),[a,d]=m.useState(!1),[u,p]=m.useState(!1),r=T(t=>t.accounts);return m.useEffect(()=>{i()},[]),h(v,{children:[a&&e(se,{user:a,onClose:()=>{d(!1)}}),u&&e(ee,{onClose:()=>{p(!1)}}),e(M,{title:"사용자",createClick:()=>{p(!0)},children:r.map(t=>e(L,{onClick:()=>{d(t)},children:`${t.name} [${t.role}] [${t.id}] `},t.id))})]})},Z=[{value:"PL",label:"PL"},{value:"DEV",label:"DEV"},{value:"TESTER",label:"TESTER"}],ee=({onClose:i})=>{const{handleSubmit:a,register:d,setValue:u}=E(),[p,r]=m.useState(!1),{addAccount:t}=k(),b=o=>{if(!o.password||!o.passwordCheck||!o.id||!o.name){r("모든 정보를 입력해주세요.");return}if(o.password!==o.passwordCheck){r("입력한 비밀번호가 동일하지 않습니다.");return}if(!o.role){r("직책을 선택하지 않았습니다.");return}t({signId:o.id,name:o.name,password:o.password,role:o.role}),i()},f=o=>{u("role",o)};return h(A,{onClose:i,children:[p?e($,{message:p,setMessage:r,duration:2e3}):null,h(oe,{onSubmit:a(b),children:[e(te,{children:"계정 생성"}),e(y,{placeholder:"아이디",...d("id")}),e(y,{placeholder:"이름",...d("name")}),e(y,{placeholder:"비밀번호",type:"password",...d("password")}),e(y,{placeholder:"비밀번호 재입력",type:"password",...d("passwordCheck")}),e(C,{options:Z,onChange:f,placeholder:"직책 설정"}),e(ne,{type:"submit",variant:"contained",children:"등록하기"})]})]})},te=s("div",{target:"e1joj12d3"})({name:"1n5m32i",styles:"font-size:35px;font-weight:bold;color:#2528c7;margin-bottom:-8px"}),oe=s("form",{target:"e1joj12d2"})({name:"k27csg",styles:"width:100%;display:flex;flex-direction:column;justify-content:center;align-items:center"}),y=s("input",{target:"e1joj12d1"})({name:"17lqpmn",styles:'background-color:white;width:80%;height:45px;border:2px solid #5d5dff;border-radius:3px;outline:none;margin-top:20px;font-size:16px;text-align:center;font-family:"Spoqa Han Sans Neo","sans-seri";::placeholder{font-family:"Spoqa Han Sans Neo","sans-seri";text-align:center;}'}),ne=s(j,{target:"e1joj12d0"})({name:"t0juvn",styles:"font-size:17px;font-weight:bold;width:82%;height:50px;background-color:#2528c7;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:20px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#2528c7;border:0px;box-shadow:0 0 0 0 black;margin-top:25px;margin-bottom:0px;transition:0s;}"}),re=[{value:"PL",label:"PL"},{value:"DEV",label:"DEV"},{value:"TESTER",label:"TESTER"}],se=({user:i,onClose:a})=>{const{handleSubmit:d,setValue:u}=E(),[p,r]=m.useState(!1),{deleteAccount:t,editAccount:b}=k(),f=n=>{if(!n.role){r("직책을 선택하지 않았습니다.");return}b(i.id,n.role),a()},o=n=>{const w=["ADMIN","PL","DEV","TESTER"];let x="PL";typeof n=="string"&&(n==="ADMIN"||n==="PL"||n==="DEV"||n==="TESTER")?(x=n,u("role",x)):typeof n=="number"&&n>=0&&n<w.length?x=w[n]:console.error("유효하지 않은 역할입니다."),u("role",x)};return h(A,{onClose:a,children:[p?e($,{message:p,setMessage:r,duration:2e3}):null,h(ae,{onSubmit:d(f),children:[h(ie,{children:[i.name," 계정 편집"]}),e(C,{options:re,onChange:o,placeholder:"직책 설정"}),e(D,{type:"submit",variant:"contained",children:"변경하기"}),e(le,{onClick:()=>{t(i.id),a()},children:"계정 삭제하기"})]})]})},ie=s("div",{target:"ekr63v83"})({name:"1cw4bdy",styles:"font-size:35px;font-weight:bold;color:#2528c7;margin-bottom:60px"}),ae=s("form",{target:"ekr63v82"})({name:"k27csg",styles:"width:100%;display:flex;flex-direction:column;justify-content:center;align-items:center"}),D=s(j,{target:"ekr63v81"})({name:"t0juvn",styles:"font-size:17px;font-weight:bold;width:82%;height:50px;background-color:#2528c7;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:20px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#2528c7;border:0px;box-shadow:0 0 0 0 black;margin-top:25px;margin-bottom:0px;transition:0s;}"}),le=s(D,{target:"ekr63v80"})({name:"mzks0u",styles:"background-color:#c72525;color:white;margin-top:80px;:hover{margin-top:85px;background-color:#c72525;}"}),ue=()=>{const i=P(a=>a.isAdmin);return e(v,{children:h(q,{children:[i()&&e(Y,{}),e(O,{})]})})};export{ue as default};
