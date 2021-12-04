export async function addCliente (cliente)  {
    //user.id = users.length + 1
    // setUsers([...users, user])
    const response = await fetch('http://localhost:8090/usuarios', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(cliente)
    })
    return await response.json();
}