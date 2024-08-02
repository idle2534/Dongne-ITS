import{a as T,h,u as E,r as u,d as $,b as c,j as o,F as P,P as M,c as r,g as q,f as _}from"./index-D3lfGxyK.js";import{u as B,B as R,i as N,C as U}from"./Button-Du56ieae.js";import{b as V,E as F,c as D,I,a as Q,G,r as H,S as J}from"./StatusMessage-CoHI4gkw.js";import{I as f}from"./IssueService-DZliz7ZU.js";const K=()=>{const e=T(),t=h(i=>i),s=E(i=>i),[d,l]=u.useState([]),[n,g]=u.useState([]),[m,a]=u.useState([]),x=$(i=>i.project),{getDev:S,changeAssignee:C,recommendIssue:p}=f(),L=async()=>{if(x){const i=await S(x.id);console.log(i),g(i)}},j=async()=>{const i=await p(t.id);console.log(i),a(i)};u.useEffect(()=>{t.id!==-1&&j(),(s.isAdmin()||s.isPl())&&L()},[t.id]),u.useEffect(()=>{const i=[];n.map(y=>{i.push({value:y.id,label:`${y.name} (${y.role})`})}),l(i)},[n]);const z=i=>{C(t.id,i)};return c(D,{title:"이슈 담당 개발자 지정",children:[o(w,{children:"현재 담당 개발자"}),o(W,{children:t.assignee?`${t.assignee.name} [${t.assignee.role}] [${t.assignee.id}] `:"담당 개발자가 지정되어 있지 않습니다"}),s.isAdmin()||s.isPl()?c(P,{children:[o(w,{children:"이슈 담당 개발자 설정"}),o(V,{options:d,onChange:z,placeholder:"프로젝트 담당자 설정 선택"})]}):null,o(w,{children:"개발자 추천"}),o(X,{children:o(Y,{children:m.map(i=>c(F,{onClick:()=>{e(M.Issue,{state:{id:i.issueResponseDto.id}})},children:[o("span",{style:{width:"73px",marginLeft:"6px",display:"flex",justifyContent:"center"},children:i.issueResponseDto.assignee?i.issueResponseDto.assignee.name:"없음"}),o("span",{style:{width:"200px",color:"#3030b8",marginLeft:"px",display:"flex",justifyContent:"center"},children:i.issueResponseDto.title}),o("span",{style:{width:"30px",color:"#3030b8",marginLeft:"5px",marginRight:"10px",display:"flex",justifyContent:"center"},children:`${i.score}%`})]},i.issueResponseDto.id))})})]})},w=r("div",{target:"e1439clr3"})({name:"18hf2yf",styles:"font-size:21px;font-weight:bold;color:#2f3542;margin-top:20px;margin-bottom:-14px"}),W=r("div",{target:"e1439clr2"})({name:"cj938l",styles:"position:relative;width:365px;height:60px;background-color:#3030b8;color:white;font-size:18px;font-weight:bold;display:flex;align-items:center;flex-direction:row;justify-content:center;margin-top:20px;border-radius:3px"}),X=r("div",{target:"e1439clr1"})({name:"17ix7q8",styles:"position:relative;height:206px;background-color:white;border:3px solid #3030b8;width:365px;margin-left:15px;margin-right:15px;margin-top:20px;border-radius:3px;overflow-y:auto;::-webkit-scrollbar{width:6px;}::-webkit-scrollbar-thumb{background-color:#2f3542;}::-webkit-scrollbar-track{background-color:#dcdcdc;}"}),Y=r("div",{target:"e1439clr0"})({name:"a1snif",styles:"width:100%;display:flex;align-items:center;flex-direction:column"}),Z=[{value:"RESOLVED",label:"RESOLVED"}],ee=[{value:"CLOSED",label:"CLOSED"},{value:"REOPENED",label:"REOPENED"}],te=[{value:"RESOLVED",label:"RESOLVED"},{value:"CLOSED",label:"CLOSED"},{value:"REOPENED",label:"REOPENED"}],oe=[{value:"BLOCKER",label:"BLOCKER"},{value:"CRITICAL",label:"CRITICAL"},{value:"MAJOR",label:"MAJOR"},{value:"MINOR",label:"MINOR"},{value:"TRIVIAL",label:"TRIVIAL"}],ie=()=>{const e=h(a=>a),t=E(a=>a);console.log(e.priority);const{updataIssue:s,deleteIssue:d,requestDeleteIssue:l,updataIssueDev:n}=f(),g=a=>{console.log(a),s({issueId:e.id,description:e.description,status:e.status,priority:a})},m=a=>{t.isDev()?n({issueId:e.id,status:a}):s({issueId:e.id,description:e.description,status:a,priority:e.priority})};return c(D,{title:`[${e.title}] 이슈 정보`,children:[o(ne,{children:e.category?e.category:"카테고리가 없습니다."}),e.id!==-1?o(b,{children:`이슈 등록 시간 : ${e.reportedDate.split("T")[0]} ${e.reportedDate.split("T")[1].split(".")[0]}`}):null,o(se,{children:c(ae,{children:['"',e.description,'"']})}),c(v,{children:[o("div",{children:e.status}),t.isPl()||t.isAdmin()||e.assignee&&t.userId===e.assignee.id||t.userId===e.reporter.id?o(I,{options:t.isPl()||t.isAdmin()?te:t.userId===e.reporter.id?ee:Z,onChange:m,placeholder:"이슈 상태 변경"}):null]}),o(b,{style:{backgroundColor:"#831717",borderColor:"#831717"},children:`${e.fixer?`해당 이슈는 ${e.fixer.name}에 의하여 해결되었습니다.`:"해당 이슈는 아직 닫히지 않았습니다."}`}),c(le,{children:[o("div",{children:e.priority}),t.isPl()||t.isAdmin()?o(I,{options:oe,onChange:g,placeholder:"이슈 우선순위 변경"}):null]}),o(re,{children:"담당 관리자"}),o(ce,{children:o("div",{children:`${e.reporter.name} [${e.reporter.id}] `})}),o(b,{style:{backgroundColor:`${t.userId===e.reporter.id||t.isAdmin()&&e.status==="DELETE_REQUEST"?"#831717":(t.isAdmin(),"#606060")}`,borderColor:`${t.userId===e.reporter.id||t.isAdmin()&&e.status==="DELETE_REQUEST"?"#831717":(t.isAdmin(),"#606060")}`,display:"flex",justifyContent:"center"},onClick:()=>{t.userId===e.reporter.id?l(e.id):t.isAdmin()&&e.status==="DELETE_REQUEST"&&d(e.id)},children:t.userId===e.reporter.id?"이슈 삭제 요청 보내기":t.isAdmin()&&e.status==="DELETE_REQUEST"?"이슈 삭제하기":t.isAdmin()?"이슈 삭제 요청이 없습니다.":"이슈 삭제 관련 권한이 없습니다."})]})},re=r("div",{target:"e1obp5k47"})({name:"10a0fxz",styles:"font-size:21px;font-weight:bold;color:#2f3542;margin-top:10px;margin-bottom:4px"}),b=r("div",{target:"e1obp5k46"})({name:"1i7cfq7",styles:"position:relative;width:365px;height:20px;background-color:#252588;border:10px solid #252588;margin-left:15px;margin-right:15px;margin-top:5px;border-radius:3px;color:white;font-weight:bold"}),ne=r(b,{target:"e1obp5k45"})({name:"pb351h",styles:"background-color:#3030b8;border:10px solid #3030b8"}),se=r("div",{target:"e1obp5k44"})({name:"1rgqe5a",styles:"position:relative;width:365px;height:90px;background-color:#3030b8;border:10px solid #3030b8;margin-left:15px;margin-right:15px;margin-top:5px;border-radius:3px;overflow-y:auto;::-webkit-scrollbar{width:6px;}::-webkit-scrollbar-thumb{background-color:#2f3542;}::-webkit-scrollbar-track{background-color:#dcdcdc;}"}),ae=r("div",{target:"e1obp5k43"})({name:"1hc3kw8",styles:"width:100%;display:flex;align-items:center;flex-direction:column;color:white"}),v=r("div",{target:"e1obp5k42"})({name:"18iyxcc",styles:"position:relative;width:365px;height:28px;background-color:#b13b3b;border:10px solid #b13b3b;color:white;font-size:22px;font-weight:bold;display:flex;align-items:center;flex-direction:row;justify-content:space-between;margin-top:5px;border-radius:3px"}),le=r(v,{target:"e1obp5k41"})({name:"x7oryc",styles:"background-color:#ffbb00;border:10px solid #ffbb00"}),ce=r(v,{target:"e1obp5k40"})({name:"1c1hu3b",styles:"background-color:#00c30d;border:10px solid #00c30d;justify-content:center"}),O=({onClose:e,edit:t})=>{const{handleSubmit:s,register:d}=B(),[l,n]=u.useState(!1),{createComment:g,changeComment:m,removeComment:a}=f(),x=h(p=>p.id);return c(G,{onClose:e,children:[l?o(Q,{message:l,setMessage:n,duration:2e3}):null,c(pe,{onSubmit:s(t?p=>{if(!p.content){n("댓글 내용을 입력해주세요.");return}t&&m(t,p.content),e()}:p=>{if(!p.content){n("댓글 내용을 입력해주세요.");return}g(x,p.content),e()}),children:[o(de,{children:t?"댓글 수정":"댓글 작성"}),o(ue,{placeholder:"댓글을 작성해주세요.",...d("content")}),o(ge,{type:"submit",variant:"contained",children:t?"댓글 변경":"댓글 작성"}),t?o(me,{onClick:()=>a(t),children:"삭제하기"}):null]})]})},de=r("div",{target:"e2rmwzc4"})({name:"1w638j5",styles:"font-size:35px;font-weight:bold;color:#2528c7;margin-bottom:30px"}),pe=r("form",{target:"e2rmwzc3"})({name:"k27csg",styles:"width:100%;display:flex;flex-direction:column;justify-content:center;align-items:center"}),ue=r("textarea",{target:"e2rmwzc2"})({name:"w7m8zc",styles:'background-color:white;width:80%;height:145px;border:2px solid #5d5dff;border-radius:3px;outline:none;margin-top:20px;font-size:16px;text-align:center;font-family:"Spoqa Han Sans Neo","sans-seri";::placeholder{font-family:"Spoqa Han Sans Neo","sans-seri";text-align:center;}'}),ge=r(R,{target:"e2rmwzc1"})({name:"15m9vqs",styles:"font-size:17px;font-weight:bold;width:82%;height:50px;background-color:#2528c7;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:65px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#2528c7;border:0px;box-shadow:0 0 0 0 black;margin-top:70px;margin-bottom:0px;transition:0s;}"}),me=r(R,{target:"e2rmwzc0"})({name:"1c92x4e",styles:"font-size:17px;font-weight:bold;color:white;width:82%;height:50px;background-color:#c72525;border:0px;box-shadow:0px 5px 0 -0.5px black;margin-top:24px;margin-bottom:5px;transition:opacity 1s linear;:hover{background-color:#c72525;border:0px;box-shadow:0 0 0 0 black;margin-top:29px;margin-bottom:0px;transition:0s;}"});var k={},xe=N;Object.defineProperty(k,"__esModule",{value:!0});var A=k.default=void 0,be=xe(H()),he=q;A=k.default=(0,be.default)((0,he.jsx)("path",{d:"M3 17.25V21h3.75L17.81 9.94l-3.75-3.75zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34a.9959.9959 0 0 0-1.41 0l-1.83 1.83 3.75 3.75z"}),"ModeEdit");const fe=({id:e,writer:t,content:s})=>{const[d,l]=u.useState(!1),n=E(g=>g.userId);return c(we,{children:[d&&o(O,{onClose:()=>{l(!1)},edit:e}),n===t.id?o(ye,{onClick:()=>{l(!0)}}):null,o(Ee,{children:t.role==="ADMIN"?"시스템":t.name}),o(ve,{children:s})]})},ye=r(A,{target:"e7v6b013"})({name:"11dk5tc",styles:"position:absolute;font-size:23px;top:13.5px;right:6px;color:white"}),we=r("div",{target:"e7v6b012"})({name:"12qr4br",styles:"position:relative;display:flex;justify-content:center;align-items:center;flex-direction:column"}),Ee=r("div",{target:"e7v6b011"})({name:"azlzmv",styles:"width:430px;margin:7px 0px 1px 0px;background-color:#656565;border-radius:2px;height:30px;font-size:15px;font-weight:bold;color:white;margin-top:10px;margin-bottom:3px;display:flex;justify-content:center;align-items:center;flex-direction:row"}),ve=r("div",{target:"e7v6b010"})({name:"1i407sc",styles:"width:420px;background-color:#eaeaea;border-radius:2px;border:5px solid #eaeaea;font-size:14px;font-weight:bold;display:flex;justify-content:center;align-items:center;flex-direction:row"}),Re=()=>{const e=_(),[t,s]=u.useState(!1),d=h(n=>n),{loadIssue:l}=f();return u.useEffect(()=>{l(e.state.id)},[]),console.log(d),c(U,{children:[t&&o(O,{onClose:()=>{s(!1)}}),o(ie,{}),o(J,{title:"변경 사항 & 댓글",createClick:()=>{s(!0)},children:d.comments.map(n=>o(fe,{id:n.id,writer:n.writer,content:n.content}))}),o(K,{})]})};export{Re as default};
