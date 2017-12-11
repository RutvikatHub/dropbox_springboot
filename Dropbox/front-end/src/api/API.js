const api = process.env.REACT_APP_CONTACTS_API_URL || 'http://localhost:8080'

const headers = {
    'Accept': 'application/json'
};

export const doLogin = (payload) =>
    fetch(`${api}/user/login`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res);
        return res.json();
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const doSignup = (payload) =>
    fetch(`${api}/user/signup`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        console.log("API.js - doSignup - " + res);
        return res.json();
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const doLogout = () =>
    fetch(`${api}/user/logout`, {
        method: 'POST',
        headers: {
            ...headers
        },
        credentials: 'include'
    }).then(res => {
        return res.json();
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const getFiles = () =>
    fetch(`${api}/user/getFiles`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include'
    }).then(res => {
        return res;
    })
        .catch(error => {
            console.log("This is error.");
            return error;
        });

export const uploadFile = (payload) =>
    fetch(`${api}/user/uploadFile`, {
        method: 'POST',
        credentials: 'include',
        mode: 'cors',
        body: payload
    }).then(res => {
        return res.json();
    })
        .catch(error => {
            console.log("This is error.");
            return error;
        });

export const deleteFile = (payload) =>
    fetch(`${api}/deleteFile`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res;
    })
        .catch(error => {
            console.log("This is error.");
            return error;
        });

export const fileShare = (payload) =>
    fetch(`${api}/user/fileShare`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res.json();
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const userAbout = (payload) =>
    fetch(`${api}/about`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const starFile = (payload) =>
    fetch(`${api}/starFile`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res;
    })
        .catch(error => {
            console.log("This is error.");
            return error;
        });

export const getDetails = () =>
    fetch(`${api}/getDetails`, {
        method: 'GET',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include'
    }).then(res => {
        console.log(res.body);
        console.log("API.js - getDetails - response " + res.overview);
        console.log("API.js - getDetails - response " + res.status);

        return res;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const createGroup = (payload) =>
    fetch(`${api}/user/createGroup`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res.json();
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const getGroups = () =>
    fetch(`${api}/user/getGroups`, {
        method: 'GET',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include'
    }).then(res => {
        return res;
    })
        .catch(error => {
            console.log("This is error.");
            return error;
        });


export const updateUsernames = (payload) =>
    fetch(`${api}/user/updateUsernames`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res.json();
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const groupShare = (payload) =>
    fetch(`${api}/user/groupShare`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res;
    })
        .catch(error => {
            console.log("This is error");
            return error;
        });

export const deleteGroup = (payload) =>
    fetch(`${api}/deleteGroup`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(payload)
    }).then(res => {
        return res;
    })
        .catch(error => {
            console.log("This is error.");
            return error;
        });