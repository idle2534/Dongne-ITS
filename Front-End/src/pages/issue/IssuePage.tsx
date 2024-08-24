import { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router";

import {
    ScrollArea,
    Element,
    Comment,
    CreateComment,
    Container,
    AssigneeControl,
    IssueControl,
} from "@/entities";

import { IssueService, useIssueStore, PAGE_URL } from "@/shared";

const IssuePage = () => {
    const location = useLocation();
    const [onCreate, setOnCreate] = useState(false);

    const issue = useIssueStore((state) => state);
    const { loadIssue, getComment } = IssueService();

    useEffect(() => {
        const issueId = location.state.id;
        loadIssue(issueId);
        getComment(issueId); // Fetch comments after loading the issue
    }, []);

    console.log(issue);

    return (
        <Container>
            {onCreate && (
                <CreateComment
                    onClose={() => {
                        setOnCreate(false);
                    }}
                />
            )}
            <IssueControl />
            <ScrollArea
                title="변경 사항 & 댓글"
                createClick={() => {
                    setOnCreate(true);
                }}
            >
                {issue.comments.map((comment) => (
                    <Comment
                        id={comment.id}
                        writer={comment.writer}
                        content={comment.content}
                    />
                ))}
            </ScrollArea>
            <AssigneeControl />
        </Container>
    );
};

export default IssuePage;
