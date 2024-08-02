import{u as w,h as n,b as i,A as s,P as v}from"./index-wnN-NG7C.js";const N=()=>{const r=w(),a="api/v1/issue",c="api/v1/comment",d="api/v1/member/account/project/role",u=n(e=>e.setIssue),I=n(e=>e.setComment),g=n(e=>e.setStatus);n(e=>e.setPriority),n(e=>e.setAssignee);const p=n(e=>e.addComment),l=n(e=>e.deleteComment),$=n(e=>e.updateComment),C=n(e=>e.assignee),y=i(e=>e.addUserIssue),m=i(e=>e.project);return{loadIssue:async e=>{const{data:t}=await s.get(`${a}?issueId=${e}`);console.log(t),u(t)},getDev:async e=>{const{data:t}=await s.get(`${d}?projectId=${e}&role=DEV`);return t},getTester:async e=>{const{data:t}=await s.get(`${d}?projectId=${e}&role=TESTER`);return t},createIssue:async e=>{const{data:t}=await s.post(`${a}/create`,e);y(t)},updataIssue:async e=>{const{data:t}=await s.put(`${a}/update`,e);u(t)},updataIssueDev:async e=>{const{data:t}=await s.put(`${a}/update/dev`,e);console.log(t),u(t)},deleteIssue:async e=>{await s.put(`${a}/deleteRequest/delete`,{issueId:e}),m&&r(v.Project,{state:{id:m.id}})},requestDeleteIssue:async e=>{await s.put(`${a}/deleteRequest`,{issueId:e}),g("DELETE_REQUEST")},changeAssignee:async(e,t)=>{const{data:o}=await s.put(C?`${a}/reassign`:`${a}/assign`,{issueId:e,assigneeId:t});console.log(o),u(o)},createComment:async(e,t)=>{const{data:o}=await s.post(`${c}/create`,{issueId:e,content:t});p(o)},changeComment:async(e,t)=>{const{data:o}=await s.put(`${c}/update`,{commentId:e,content:t});$(o.id,o.content)},removeComment:async e=>{const{data:t}=await s.put(`${c}/delete`,{commentId:e});l(t.id)},recommendIssue:async e=>{const{data:t}=await s.get(`${a}/issueRecommend?issueId=${e}`);return t},getComment:async e=>{const{data:t}=await s.get(`${c}?issueId=${e}`);I(t)}}};export{N as I};
