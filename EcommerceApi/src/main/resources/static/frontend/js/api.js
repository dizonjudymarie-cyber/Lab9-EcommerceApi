export async function apiFetch(url, options = {}) {

    const response = await fetch(url, {
        ...options,
        credentials: "include"
    });

    if (response.status === 401) {
        window.location.href = "/login.html";
        return;
    }

    if (response.status === 403) {
        alert("Access Denied: You do not have permission.");
        return;
    }

    return response;
}