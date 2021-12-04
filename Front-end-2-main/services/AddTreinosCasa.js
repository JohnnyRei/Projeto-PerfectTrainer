export async function addTreinosCasa (treinosCasa)  {
    //user.id = users.length + 1
    // setUsers([...users, user])
    const response = await fetch('http://localhost:8090/treinosCasa', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(treinosCasa)
    })
    return await response.json();
}