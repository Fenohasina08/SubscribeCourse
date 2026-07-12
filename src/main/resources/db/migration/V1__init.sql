CREATE TABLE "users" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    user_name VARCHAR(50),
    email VARCHAR(255) UNIQUE NOT NULL
                    );

CREATE TABLE courses (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     title VARCHAR(255) NOT NULL,
     start_date TIMESTAMPTZ,
     end_date TIMESTAMPTZ
);

CREATE TABLE subscriptions (
     user_id UUID NOT NULL,
     course_id UUID NOT NULL,
     created_at TIMESTAMPTZ DEFAULT now(), -- Pratique pour savoir QUAND l'inscription a eu lieu

    -- On crée les clés étrangères pour lier aux tables existantes
     CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
     CONSTRAINT fk_course FOREIGN KEY(course_id) REFERENCES courses(id) ON DELETE CASCADE,

    -- On définit une clé primaire composée pour éviter les doublons (un user ne peut pas s'inscrire 2x au même cours)
     PRIMARY KEY (user_id, course_id)
);