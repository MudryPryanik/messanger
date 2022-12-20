create table if not exists users (
    id uuid primary key not null,
    username varchar not null,
    phone_number varchar not null,
    password varchar not null,
    account_status varchar not null,
    created_at timestamp not null default now()
);

create table if not exists chats (
    id uuid primary key not null,
    created_at timestamp not null default now()
);

create table if not exists chats_accounts (
    chat_id uuid references chats (id),
    account_id uuid references users (id)
);

create table if not exists messages (
    id uuid primary key not null,
    sender_id uuid references users (id),
    body text not null,
    chat_id uuid references chats (id),
    created_at timestamp not null default now()
)