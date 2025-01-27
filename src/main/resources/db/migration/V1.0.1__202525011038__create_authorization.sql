CREATE TABLE destaxa.authorization (id                     uuid NOT NULL,
                                    card_number            varchar(240) NOT NULL,
                                    value                  numeric(19,2) NOT NULL,
                                    installments           integer NOT NULL,
                                    cvv                    varchar(3),
                                    exp_moth               integer NOT NULL,
                                    exp_year               integer NOT NULL,
                                    holder_name            varchar(100)
                                    CONSTRAINT authorization_pkey PRIMARY KEY (id));