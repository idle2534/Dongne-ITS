import { create } from "zustand";
import { immer } from "zustand/middleware/immer";

export const useProjectStore = create<Project.ProjectStore>()(
  immer((set) => ({
    projects: [],
    project: false,
    userIssues: [],

    setProjects: (projects) => {
      if (projects) {
        for (const project of projects) {
          if (project.issues) {
            for (const issue of project.issues) {
              if (!issue.comments)
                issue.comments = [];
            }
          }
          else {
            project.issues = [];
          }
  
          if (!project.members)
            project.members = [];
        }
      }
      else {
        projects = [];
      }

      set(() => ({ projects: projects }));
    },

    setProject: (project) => {
      if (project) {
        if (project.issues) {
          for (const issue of project.issues) {
            if (!issue.comments)
              issue.comments = [];
          }
        }
        else {
          project.issues = [];
        }

        if (!project.members)
          project.members = [];
      }

      set(() => ({
        project: project,
      }));
    },

    setProjectIssues: (data: Issue.Issue[]) => {
      if (data) {
        for (const issue of data) {
          if (!issue.comments)
            issue.comments = [];
        }
      }
      else {
        data = [];
      }
      
      set((state) => {
        if (state.project) state.project.issues = data;
      });
    },

    addProject: (project) => {
      if (project) {
        if (project.issues) {
          for (const issue of project.issues) {
            if (!issue.comments)
              issue.comments = [];
          }
        }
        else {
          project.issues = [];
        }

        if (!project.members)
          project.members = [];
      }

      set((state) => {
        state.projects.push(project);
      });
    },

    setProjectMember: (id, user, type) => {
      set((state) => {
        if (type === "ADD" && state.project) state.project.members.push(user);
        else if (type === "DELETE" && state.project)
          state.project.members.splice(
            state.project.members.findIndex((member) => member.id === user.id),
            1
          );
      });
    },

    deleteProject: (id: number) => {
      set((state) => {
        const projectIndex = state.projects.findIndex(
          (project) => project.id === id
        );

        if (projectIndex !== -1) state.projects.splice(projectIndex, 1);
      });
    },

    setUserIssue: (data) => {
      if (data) {
        for (const issue of data)
          if (!issue.comments)
            issue.comments = [];
      }
      else {
        data = [];
      }
      
      set((state) => {
        state.userIssues = data;
      });
    },

    addUserIssue: (data) => {
      if (data && !data.comments)
        data.comments = [];

      set((state) => {
        if (state.project) state.project.issues.push(data);
        state.userIssues.push(data);
      });
    },
  }))
);
