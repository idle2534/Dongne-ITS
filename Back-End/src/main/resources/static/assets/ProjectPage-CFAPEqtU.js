import{r as f,u as $,e as T,d as h,b as p,j as t,F as C,c as i,f as E,a as z,P as w}from"./index-CVy9vN2B.js";import{B as b,u as P,C as q}from"./Button-B1BA7G-x.js";import{a as y,b as D,c as M,G as N,I as B,S as k,E as v}from"./StatusMessage-BnCJKAwZ.js";import{A as L,P as S,d as H}from"./Backspace-Dx890ghG.js";import{I as F}from"./IssueService-CGrr8czY.js";const G=()=>{const[m,g]=f.useState([]),[c,d]=f.useState(!1),s=$(n=>n.isAdmin),u=T(n=>n.accounts),r=h(n=>n.project),{loadAllAccountList:x}=L(),{setProjectMember:o,deleteProject:e}=S();f.useEffect(()=>{x()},[]),f.useEffect(()=>{const n=[];u.map(l=>{l.role!=="PL"&&l.role!=="ADMIN"&&n.push({value:l.id,label:`${l.name} (${l.role})`})}),g(n)},[u]);const a=n=>{r&&r.members.findIndex(l=>`${l.id}`===n)===-1&&o(r.id,u.find(l=>`${l.id}`===n),"ADD")},A=n=>{r&&o(r.id,r.members.find(l=>l.id===n),"DELETE")};return p(M,{title:"프로젝트 설정",children:[c?t(y,{message:c,setMessage:d,duration:2e3}):null,t(j,{children:"프로젝트 담당자 설정"}),t(D,{options:m,onChange:a,placeholder:"프로젝트 담당자 설정 선택"}),t(O,{children:t(U,{children:r?r.members.map(n=>t("div",{children:p(_,{children:[`${n.name} [${n.role}] [${n.id}]`,n.role!=="PL"?t(R,{onClick:()=>{A(n.id)}}):null]})},n.id)):null})}),s()?p(C,{children:[t(j,{children:"프로젝트 삭제"}),t(V,{onClick:()=>{r&&e(r.id)},children:"삭제하기"})]}):null]})},j=i("div",{target:"ekpx4af5"})({name:"1vj8pk4",styles:"font-size:23px;font-weight:bold;color:#2f3542;margin-top:26px;margin-bottom:-10px"}),O=i("div",{target:"ekpx4af4"})({name:"phv6ia",styles:"position:relative;background-color:white;width:80%;height:200px;background-color:#5d5dff;border:3.5px solid #5d5dff;margin-left:15px;margin-right:15px;margin-top:10px;border-radius:3px;overflow-y:auto;::-webkit-scrollbar{width:6px;}::-webkit-scrollbar-thumb{background-color:#2f3542;}::-webkit-scrollbar-track{background-color:#dcdcdc;}"}),U=i("div",{target:"ekpx4af3"})({name:"a1snif",styles:"width:100%;display:flex;align-items:center;flex-direction:column"}),R=i(H,{target:"ekpx4af2"})({name:"anun7w",styles:"position:absolute;right:10px"}),_=i("div",{target:"ekpx4af1"})({name:"all762",styles:"position:relative;background-color:white;width:290px;height:40px;border-radius:3px;margin-top:8px;margin-bottom:3px;color:#5d5dff;font-size:16px;display:flex;align-items:center;justify-content:center"}),V=i(b,{target:"ekpx4af0"})({name:"1c92x4e",styles:"font-size:17px;font-weight:bold;color:white;width:82%;height:50px;background-color:#c72525;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:24px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#c72525;border:0px;box-shadow:0 0 0 0 black;margin-top:29px;margin-bottom:0px;transition:0s;}"}),Y=({onClose:m})=>{const{handleSubmit:g,register:c}=P(),[d,s]=f.useState(!1),{createIssue:u}=F(),r=h(o=>o.project);return p(N,{onClose:m,children:[d?t(y,{message:d,setMessage:s,duration:2e3}):null,p(K,{onSubmit:g(o=>{if(r){if(!o.title||!o.description){s("모든 정보를 입력해주세요.");return}u({title:o.title,description:o.description,projectId:r.id,category:o.category}),m()}}),children:[t(J,{children:"이슈 생성"}),t(I,{placeholder:"이슈 이름",...c("title")}),t(I,{placeholder:"이슈 카테고리",...c("category")}),t(Q,{placeholder:"이슈 설명",...c("description")}),t(W,{type:"submit",variant:"contained",children:"등록하기"})]})]})},J=i("div",{target:"eiy97um4"})({name:"1w638j5",styles:"font-size:35px;font-weight:bold;color:#2528c7;margin-bottom:30px"}),K=i("form",{target:"eiy97um3"})({name:"k27csg",styles:"width:100%;display:flex;flex-direction:column;justify-content:center;align-items:center"}),I=i("input",{target:"eiy97um2"})({name:"17lqpmn",styles:'background-color:white;width:80%;height:45px;border:2px solid #5d5dff;border-radius:3px;outline:none;margin-top:20px;font-size:16px;text-align:center;font-family:"Spoqa Han Sans Neo","sans-seri";::placeholder{font-family:"Spoqa Han Sans Neo","sans-seri";text-align:center;}'}),Q=i("textarea",{target:"eiy97um1"})({name:"w7m8zc",styles:'background-color:white;width:80%;height:145px;border:2px solid #5d5dff;border-radius:3px;outline:none;margin-top:20px;font-size:16px;text-align:center;font-family:"Spoqa Han Sans Neo","sans-seri";::placeholder{font-family:"Spoqa Han Sans Neo","sans-seri";text-align:center;}'}),W=i(b,{target:"eiy97um0"})({name:"15m9vqs",styles:"font-size:17px;font-weight:bold;width:82%;height:50px;background-color:#2528c7;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:65px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#2528c7;border:0px;box-shadow:0 0 0 0 black;margin-top:70px;margin-bottom:0px;transition:0s;}"}),X=[{value:"TITLE",label:"이름"},{value:"STATUS",label:"상태"},{value:"PRIORITY",label:"우선순위"},{value:"ASSIGNEE",label:"담당 개발자"}],Z=()=>{const{handleSubmit:m,register:g,setValue:c}=P(),[d,s]=f.useState(!1),{loadProject:u,searchIssue:r}=S(),x=h(a=>a.project),o=a=>{if(x){if(!a.keyword||a.keyword===""){u(x.id);return}if(!a.category){s("카테고리를 설정 해주세요.");return}r(a.category,x.id,a.keyword)}},e=a=>{c("category",a)};return p(C,{children:[d?t(y,{message:d,setMessage:s,duration:2e3}):null,p(ee,{onSubmit:m(o),children:[t(te,{children:"이슈 검색"}),t(oe,{placeholder:"검색 내용을 입력해주세요",...g("keyword")}),p("div",{style:{marginTop:"5px",width:"95%",display:"flex",flexDirection:"row",justifyContent:"space-between",alignItems:"center"},children:[t(ne,{type:"submit",variant:"contained",children:"검색하기"}),t(B,{options:X,onChange:e,placeholder:"카테고리 설정"})]})]})]})},ee=i("form",{target:"euotsoc3"})({name:"1rgx2f4",styles:"background-color:#5d5dff;width:97%;height:120px;border-radius:3px;margin-top:6px;display:flex;flex-direction:column;justify-content:center;align-items:center"}),te=i("div",{target:"euotsoc2"})({name:"1pdmgdq",styles:"font-size:21px;font-weight:bold;color:white;margin-bottom:3px"}),oe=i("input",{target:"euotsoc1"})({name:"4q86x2",styles:'background-color:white;width:94%;height:27px;border:2px solid #5d5dff;border-radius:3px;outline:none;font-size:16px;text-align:center;font-family:"Spoqa Han Sans Neo","sans-seri";::placeholder{font-family:"Spoqa Han Sans Neo","sans-seri";text-align:center;}'}),ne=i(b,{target:"euotsoc0"})({name:"fo1eo9",styles:"font-size:15px;font-weight:bold;width:50%;height:30px;background-color:#2528c7;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:-1px;margin-bottom:9px;transition:opacity 1s linear;:hover{background-color:#2528c7;border:0px;box-shadow:0 0 0 0 black;margin-top:4px;margin-bottom:4px;transition:0s;}"}),ce=()=>{const m=E(),g=z(),[c,d]=f.useState(!1),s=h(e=>e.project);h(e=>e.setProject);const u=h(e=>e.userIssues),{loadProject:r,loadUserIssues:x}=S(),o=$(e=>e);return f.useEffect(()=>{r(m.state.id),(o.isDev()||o.isTester())&&x(m.state.id,o.role)},[]),p(q,{children:[c&&t(Y,{onClose:()=>{d(!1)}}),p(k,{title:"이슈",createClick:o.isTester()?()=>{d(!0)}:void 0,children:[t(Z,{}),s&&s.issues.map(e=>t(v,{onClick:()=>{g(w.Issue,{state:{id:e.id}})},children:`${e.title} [${e.status}/${e.priority}] [${e.assignee?e.assignee.name:"담당자 없음"}]`},e.id))]}),o.isDev()||o.isTester()?t(k,{title:"담당 이슈",children:s&&u.map(e=>t(v,{onClick:()=>{g(w.Issue,{state:{id:e.id}})},children:`${e.title} [${e.status}/${e.priority}] [${e.assignee?e.assignee.name:"담당자 없음"}]`},e.id))}):null,o.isAdmin()||o.isPl()?t(G,{}):null]})};export{ce as default};
