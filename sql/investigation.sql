-- Keep a log of any SQL queries you execute as you solve the mystery.

-- ============================================================================
-- FIFTYVILLE INVESTIGATION LOG
-- Investigator: [Dave]
-- Date: [3/15/26]
-- ============================================================================

-- ----------------------------------------------------------------------------
-- STEP 1: Find the crime scene report
-- Looking for the theft that occurred on July 28, 2025 at Humphrey Street
-- ----------------------------------------------------------------------------
SELECT * FROM crime_scene_reports
WHERE year = 2025 AND month = 7 AND day = 28
AND street = 'Humphrey Street';

-- Result: Theft of CS50 duck at 10:15am at Humphrey Street bakery
-- Three witnesses were interviewed

-- ----------------------------------------------------------------------------
-- STEP 2: Read witness interviews from July 28, 2025
-- Need to find clues about the thief's identity and escape plan
-- ----------------------------------------------------------------------------
SELECT name, transcript FROM interviews
WHERE year = 2025 AND month = 7 AND day = 28;

-- Key clues from witnesses:
-- Ruth: Thief left within 10 minutes in a car (10:15-10:25am)
-- Eugene: Thief withdrew money from ATM on Leggett Street earlier that morning
-- Raymond: Thief made phone call < 1 minute, planning to take earliest flight
--          out of Fiftyville on July 29, asked someone to buy ticket

-- ----------------------------------------------------------------------------
-- STEP 3: Check bakery security logs for cars exiting 10:15-10:25am
-- Thief left within 10 minutes of 10:15am theft
-- ----------------------------------------------------------------------------
SELECT * FROM bakery_security_logs
WHERE year = 2025 AND month = 7 AND day = 28
AND hour = 10 AND minute BETWEEN 15 AND 25
AND activity = 'exit';

-- License plates that exited: 5P2BI95, 94KL13X, 6P58WS2, 4328GD8,
-- G412CB7, L93JTIZ, 322W7JE, 0NTHK55, 1106N58

-- ----------------------------------------------------------------------------
-- STEP 4: Find ATM withdrawals on Leggett Street on July 28, 2025
-- Eugene saw thief withdrawing money from Leggett Street ATM
-- ----------------------------------------------------------------------------
SELECT * FROM atm_transactions
WHERE year = 2025 AND month = 7 AND day = 28
AND atm_location = 'Leggett Street'
AND transaction_type = 'withdraw';

-- Get account numbers that withdrew from Leggett Street ATM

-- ----------------------------------------------------------------------------
-- STEP 5: Match ATM accounts to people via bank_accounts table
-- Need to find who owns the accounts that withdrew from Leggett Street
-- ----------------------------------------------------------------------------
SELECT people.name, people.license_plate, people.phone_number,
       bank_accounts.account_number
FROM people
JOIN bank_accounts ON people.id = bank_accounts.person_id
WHERE bank_accounts.account_number IN (
    SELECT account_number FROM atm_transactions
    WHERE year = 2025 AND month = 7 AND day = 28
    AND atm_location = 'Leggett Street'
    AND transaction_type = 'withdraw'
);

-- ----------------------------------------------------------------------------
-- STEP 6: Cross-reference bakery exit license plates with ATM withdrawers
-- Thief must match BOTH: exited bakery 10:15-10:25 AND withdrew from Leggett St ATM
-- ----------------------------------------------------------------------------
SELECT people.name, people.license_plate, people.phone_number, people.passport_number
FROM people
JOIN bank_accounts ON people.id = bank_accounts.person_id
WHERE people.license_plate IN (
    SELECT license_plate FROM bakery_security_logs
    WHERE year = 2025 AND month = 7 AND day = 28
    AND hour = 10 AND minute BETWEEN 15 AND 25
    AND activity = 'exit'
)
AND bank_accounts.account_number IN (
    SELECT account_number FROM atm_transactions
    WHERE year = 2025 AND month = 7 AND day = 28
    AND atm_location = 'Leggett Street'
    AND transaction_type = 'withdraw'
);

-- Result: Bruce (license_plate: 94KL13X, phone: (367) 555-5533)

-- ----------------------------------------------------------------------------
-- STEP 7: Verify Bruce made a phone call lasting less than 60 seconds on July 28
-- Raymond heard thief make call < 1 minute
-- ----------------------------------------------------------------------------
SELECT caller, receiver, duration FROM phone_calls
WHERE year = 2025 AND month = 7 AND day = 28
AND duration < 60
AND (caller = '(367) 555-5533' OR receiver = '(367) 555-5533');

-- Result: Bruce called (375) 555-8161 for 45 seconds at 10:15am

-- ----------------------------------------------------------------------------
-- STEP 8: Find who owns phone number (375) 555-8161 (the accomplice)
-- This person received the call from the thief
-- ----------------------------------------------------------------------------
SELECT name, phone_number FROM people
WHERE phone_number = '(375) 555-8161';

-- Result: Robin (the accomplice)

-- ----------------------------------------------------------------------------
-- STEP 9: Find the earliest flight from Fiftyville on July 29, 2025
-- Thief planned to take earliest flight out of Fiftyville tomorrow
-- ----------------------------------------------------------------------------
SELECT flights.id, flights.hour, flights.minute, airports.city
FROM flights
JOIN airports ON flights.destination_airport_id = airports.id
WHERE flights.origin_airport_id = 8
AND flights.year = 2025 AND flights.month = 7 AND flights.day = 29
ORDER BY flights.hour, flights.minute
LIMIT 1;

-- Result: Flight 36 at 8:20am to New York City (airport_id 4, LGA)

-- ----------------------------------------------------------------------------
-- STEP 10: Verify Bruce was on flight 36 to New York City
-- Check passenger manifest for the earliest flight
-- ----------------------------------------------------------------------------
SELECT people.name, flights.id, flights.hour, flights.minute, airports.city
FROM people
JOIN passengers ON people.passport_number = passengers.passport_number
JOIN flights ON passengers.flight_id = flights.id
JOIN airports ON flights.destination_airport_id = airports.id
WHERE people.name = 'Bruce'
AND flights.year = 2025 AND flights.month = 7 AND flights.day = 29;

-- Result: Confirmed - Bruce was on flight 36 to New York City

-- ----------------------------------------------------------------------------
-- STEP 11: Verify Robin (accomplice) also made short calls on July 28
-- Confirm the phone call connection between thief and accomplice
-- ----------------------------------------------------------------------------
SELECT caller, receiver, duration FROM phone_calls
WHERE year = 2025 AND month = 7 AND day = 28
AND duration < 60
AND (caller = '(375) 555-8161' OR receiver = '(375) 555-8161');

-- Result: Confirmed bidirectional short calls between Bruce and Robin

-- ============================================================================
-- INVESTIGATION COMPLETE
-- ============================================================================
