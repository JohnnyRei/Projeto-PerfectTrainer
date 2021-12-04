import React from 'react'
import Link from 'next/link'
import TreinosCasaTable from '../../components/Tables/TreinosCasaTables'
import TreinosAcademiaTables from '../../components/Tables/TreinosAcademiaTables'

export default function Usuario() {
  const treinos = [{
    id: 'aaaa',
    personal: 'aaa',
    cliente: 'cliente',
    data: 'data',
    endereco: 'endereco',
    tipo: 'tipo',
    academia: 'academia'
  }]

  // const editRow = personal => {
  //   setEditing(true)

  //   setCurrentUser({ personal: personal.nome, email: user.email, senha: user.senha })
  // }

  return (
    <div>
      <Link href='/'>
        <button>Voltar</button>
      </Link>
      <TreinosCasaTable treinosCasas={treinos} />
      {/* TROCAR treinos pelo data do banco */}
      <TreinosAcademiaTables treinosAcademias={treinos} />
    </div>
  )
}
