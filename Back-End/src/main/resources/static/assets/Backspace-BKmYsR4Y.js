import{e as i,A as c,d as a,a as g,P as I,g as w}from"./index-D9bioQs8.js";import{i as y}from"./Button-BhoBN7Hb.js";import{r as f}from"./StatusMessage-CK20Z1ur.js";const B=()=>{const o=i(e=>e.setAccounts),u=i(e=>e.setAccount),l=i(e=>e.deleteAccount),j=i(e=>e.addAccount),n="api/v1/member";return{loadAllAccountList:async()=>{const{data:e}=await c.get(`${n}/account`);o(e)},addAccount:async e=>{const{data:r}=await c.post(`${n}/signUp`,e);j(r)},deleteAccount:async e=>{await c.put(`${n}/delete`,{id:e}),l(e)},editAccount:async(e,r)=>{console.log(r),console.log(e),await c.put(`${n}/account/update`,{id:e,role:r}),u(e,r)}}},V=()=>{const o="api/v1/project",u="api/v1/issue",l=a(t=>t.setProjects),j=a(t=>t.setProject),n=a(t=>t.addProject),A=a(t=>t.setProjectMember),p=a(t=>t.deleteProject),m=a(t=>t.setProjectIssues),$=a(t=>t.setUserIssue),e=g();return{loadAllProjectList:async()=>{const{data:t}=await c.get(`${o}`);l(t)},loadProject:async t=>{const{data:s}=await c.get(`${o}/${t}`);j(s)},searchIssue:async(t,s,d)=>{const{data:v}=await c.get(`${u}/search?category=${t}&projectId=${s}&keyword=${d}`);m(v)},addProject:async t=>{const{data:s}=await c.post(`${o}/create`,t);n(s)},setProjectMember:async(t,s,d)=>{d==="DELETE"?await c.put(`${o}/${t}/member/delete`,{removeMemberId:s.id}):await c.put(`${o}/${t}/member/add`,{addMemberId:s.id}),A(t,s,d)},deleteProject:async t=>{await c.put(`${o}/${t}`),p(t),e(I.Setting)},loadUserIssues:async(t,s)=>{const{data:d}=await c.get(`${u}/${t}/${s==="DEV"?"dev":"tester"}`);$(d)}}};var P={},L=y;Object.defineProperty(P,"__esModule",{value:!0});var b=P.default=void 0,S=L(f()),U=w;b=P.default=(0,S.default)((0,U.jsx)("path",{d:"M22 3H7c-.69 0-1.23.35-1.59.88L0 12l5.41 8.11c.36.53.9.89 1.59.89h15c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2m-3 12.59L17.59 17 14 13.41 10.41 17 9 15.59 12.59 12 9 8.41 10.41 7 14 10.59 17.59 7 19 8.41 15.41 12z"}),"Backspace");export{B as A,V as P,b as d};
