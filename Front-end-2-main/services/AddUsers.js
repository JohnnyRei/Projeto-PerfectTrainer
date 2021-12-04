export async function addUser (user)  {
    //user.id = users.length + 1
    // setUsers([...users, user])
    const response = await fetch('http://localhost:8090/personais', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(user)
    })
    return await response.json();
}