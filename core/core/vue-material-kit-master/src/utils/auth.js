const setTokenInLocalStorage = (tokenInfo) => {
    // console.log('SET LOCAL STORAGE')
    localStorage.setItem("accessToken", 'Bearer ' + tokenInfo.access_token);
    localStorage.setItem("refreshTken", tokenInfo.refresh_token);
};

const deleteTokenInLocalStorage = () => {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshTken");
    localStorage.removeItem("username");
};
export {deleteTokenInLocalStorage, setTokenInLocalStorage}