import { AxiosResponse } from "axios";
import { API } from "@/shared/configs/axios";
import { useAccountStore } from "@/shared";

export const AccountService = () => {
  const setAccounts = useAccountStore((state) => state.setAccounts);
  const setAccount = useAccountStore((state) => state.setAccount);
  const setDeleteAccount = useAccountStore((state) => state.deleteAccount);
  const setAddAccount = useAccountStore((state) => state.addAccount);

  const URL = "api/v1/member";

  const loadAllAccountList = async () => {
    try {
      const response = await API.get(`${URL}/account`);
      console.log("API Response:", response);
      const { data } = response as AxiosResponse<User.LoadAccountListResDto>;

      setAccounts(data);
    } catch (error) {
      console.error("Error fetching account list:", error);
    }
  };

  const addAccount = async (body: User.SignUpRepDto) => {
    const { data } = (await API.post(
        `${URL}/signUp`,
        body
    )) as AxiosResponse<User.User>;

    setAddAccount(data);
  };

  const editAccount = async (id: number, role: User.Role) => {
    await API.put(`${URL}/update`, {
      id: id,
      role: role,
    });

    setAccount(id, role);
  };

  const deleteAccount = async (id: number) => {
    await API.put(`${URL}/delete`, {
      id: id,
    });

    setDeleteAccount(id);
  };

  return { loadAllAccountList, addAccount, deleteAccount, editAccount };
};
