# Projekto pavadinimas: Senukai

## Nuoroda į testuojamą puslapį
Projektas automatizuoja testavimą svetainėje [Senukai.lt](https://www.senukai.lt/). Tai apima įvairias vartotojo paskyros veiklas, tokias kaip registracija, paskyros aktyvavimas, prisijungimas ir paskyros ištrynimas.

## Testų scenarijų ir jų žingsnių aprašymai

### 1. **Registracija su teisingais duomenimis (testSenukaiRegistracijaCorrectDetails)**
**Veiksmai:**
1. Atidaryti Senukai.lt svetainę.
2. Paspausti mygtuką „Prisijungti“.
3. Paspausti mygtuką „Registruotis“.
4. Užpildyti registracijos formą su teisingu vardu, pavarde, el. paštu ir slaptažodžiu.
5. Pateikti registracijos formą.
6. Patikrinti URL, žinutę ir antraštę po sėkmingos registracijos.

**Tikėtinas rezultatas:**
- URL turi būti: `https://www.senukai.lt/users/confirmation/wait`
- Pateikta žinutė turi būti: `"Netrukus el.paštu gausi paskyros aktyvavimo nuorodą. Sek instrukcijas el.pašte ir aktyvuok savo SMART NET paskyrą."`
- Antraštė turi būti: `"Senukai.lt - Paskyros aktyvavimas"`

---

### 2. **Registracija su neteisingu el. paštu (testSenukaiRegistracijaInvalidEmail)**
**Veiksmai:**
1. Atidaryti Senukai.lt svetainę.
2. Paspausti mygtuką „Prisijungti“.
3. Paspausti mygtuką „Registruotis“.
4. Užpildyti registracijos formą su neteisingu el. paštu (pvz., `demotestavimuigmailcom`).
5. Pateikti registracijos formą.
6. Patikrinti klaidos žinutę, kuri atsiranda puslapyje.

**Tikėtinas rezultatas:**
- Klaidos žinutė turi būti: `"Neteisingas el. paštas"`

---
### 3. **Paskyros aktyvavimas (testActivateAccount)**

**Tikslas**: Patikrinti, ar paskyra sėkmingai aktyvuojama.

**Žingsniai**:
1. Užregistruoti vartotoją (kaip aprašyta aukščiau).
2. Atidaryti el. pašto dėžutę ir atidaryti laišką su aktyvavimo nuoroda.
3. Spustelėti ant aktyvavimo nuorodos.
4. Patikrinti, ar vartotojas yra nukreipiamas į paskyros aktyvavimo puslapį.

**Tikėtinas rezultatas**:
- Vartotojas nukreipiamas į puslapį, kuriame mato žinutę: "Sveiki, Demo", bei žalią burbuliuką prie vartotojo logo."

---

### 4. **Prisijungimas su teisingais duomenimis (testSenukaiLoginCorrectDetails)**

**Tikslas**: Patikrinti, ar vartotojas gali prisijungti su teisingais duomenimis.

**Žingsniai**:
1. Eiti į Senukai.lt prisijungimo puslapį.
2. Užpildyti prisijungimo formą su teisingais duomenimis:
    - El. paštas: demotestavimui@gmail.com
    - Slaptažodis: VCSDemo@123
3. Pateikti formą.
4. Patikrinti, ar vartotojas sėkmingai prisijungia ir mato savo paskyrą.

**Tikėtinas rezultatas**:
- Vartotojas nukreipiamas į puslapį, kuriame mato žinutę: "Sveiki, Demo", bei žalią burbuliuką prie vartotojo logo.

---

### 5. **Paskyros ištrynimas (testDeleteAccount)**

**Tikslas**: Patikrinti, ar vartotojas gali ištrinti savo paskyrą.

**Žingsniai:**
1. Prisijungti prie Senukai.lt svetainės su teisingais duomenimis (el. paštas: `demotestavimui@gmail.com`, slaptažodis: `VCSDemo@123`).
2. Eiti į vartotojo paskyros puslapį.
3. Paslinkti puslapį iki „Ištrinti paskyrą“ skyriaus.
4. Paspausti mygtuką „Ištrinti paskyrą“.
5. Atsidariusiame prompt įvesti el. paštą, kad patvirtintumėte paskyros ištrynimą.
6. Patikrinti, ar paskyra buvo ištrinta sėkmingai (bandome prisijungti iš naujo).

**Tikėtinas rezultatas:**
- Pabandžius prisijungti gauname žinutę: "Neteisingai įvedėte savo el.paštą/slaptažodį arba jūsų slaptažodis nebegalioja"

---

## Naudojimo instrukcijos

1. **Priklausomybės**:
    - Selenium WebDriver
    - TestNG
    - Apache Commons IO (screenshotams)
    - WebDriverManager (chromedriver'io valdymui)

2. **Testų paleidimas**:
    - Įsitikinkite, kad turite įdiegtus visus reikalingus įrankius (Selenium, TestNG, ir pan.).
    - Paleiskite testus per IDE (pvz., IntelliJ, Eclipse) arba komandų eilutėje naudodami Maven/Gradle.

   **Pavyzdys su Maven**:
   ```bash
   mvn clean test
