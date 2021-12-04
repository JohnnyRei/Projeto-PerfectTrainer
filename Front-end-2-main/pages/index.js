import Link from 'next/link'

export default function Home() {
    return (
        <div className="grid-header">
            <h1 className="titulo">Perfect Trainer</h1>
            <h2>Encontre seu personal ideal</h2>
            <Link href="/cadastro-clientes" >
                <button>Cadastrar Usuario</button>
            </Link>
            <Link href="/cadastro-user">
                <button>Cadastrar Personal</button>
            </Link>

            <div className="content">

            </div>
        </div>
    );
}