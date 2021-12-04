export async function addTreinosAcademia (treinosAcademia)  {
    //user.id = users.length + 1
    // setUsers([...users, user])
    const response = await fetch('http://localhost:8090/treinosAcademia', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(treinosAcademia)
    })
    return await response.json();
}