-- Questions table seed data



CREATE TABLE question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    question_text VARCHAR(255) NOT NULL,
    option_a VARCHAR(255) NOT NULL,
    option_b VARCHAR(255) NOT NULL,
    option_c VARCHAR(255) NOT NULL,
    option_d VARCHAR(255) NOT NULL,
    correct_option CHAR(1) NOT NULL
);


-- Inserting into the question table
INSERT INTO public.question (question_text,  option_a, option_b, option_c, option_d,correct_option )
VALUES 
    ('What is the capital of France?', 'Paris', 'crris', 'Sydney', 'Egypt','A' ),
    ('What is 2 + 2?', '5', '4', '7', '10','B');

-- Inserting into the quiz_session table
--INSERT INTO quiz_session (correct_answers, incorrect_answers, user_name)
--VALUES 
  --  (2, 0, 'User1'),
   -- (1, 1, 'User2');

-- Inserting into the quiz_session_responses table
--INSERT INTO quiz_session_responses (quiz_session_id, responses_id)
--VALUES 
 --   (1, 1),
   -- (2, 2);

-- Inserting into the user_response table
--INSERT INTO user_response (is_correct, question_id, selected_option)
--VALUES 
  --  (true, 1, 'A'),
    --(false, 2, 'B');
    
    
    
 CREATE TABLE quiz_session (
    id INT AUTO_INCREMENT PRIMARY KEY,
    correct_answers INT NOT NULL,
    incorrect_answers INT NOT NULL,
    user_name VARCHAR(255) NOT NULL
);

-- Create table for 'quiz_session_responses'
CREATE TABLE quiz_session_responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quiz_session_id INT NOT NULL,
    responses_id INT NOT NULL,
    FOREIGN KEY (quiz_session_id) REFERENCES quiz_session(id),
    FOREIGN KEY (responses_id) REFERENCES question(id)
);

-- Create table for 'user_response'
CREATE TABLE user_response (
    id INT AUTO_INCREMENT PRIMARY KEY,
    is_correct BOOLEAN NOT NULL,
    question_id INT NOT NULL,
    selected_option VARCHAR(10) NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(id)
);
