import { API } from "@/shared/configs/axios";
import { useNavigate } from "react-router-dom";
import { PAGE_URL, useUserStore } from "@/shared";

export const AuthService = () => {
  const signIn = useUserStore((state) => state.signIn);
  const navigate = useNavigate();

  const signin = async (body: User.SignInReqDto) => {
    try {
      const { data } = await API.post("/api/v1/member/signIn", body);
      signIn(data);
      navigate(PAGE_URL.Setting); // Redirect to settings page or desired page
    } catch (error) {
      console.error("Failed to sign in", error);
    }
  };

  return { signin };
};
