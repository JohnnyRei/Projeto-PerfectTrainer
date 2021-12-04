const deleteTreinosAcademia = treinosAcademia => {
    treinosAcademia.id = treinosAcademia.length + 1
    // setUsers([...users, user])
    const response = await fetch(`${API_ENDPOINT}/treinosAcademia/${treinosAcademia.id}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(treinosAcademia)
    })
    return await response.json();
}