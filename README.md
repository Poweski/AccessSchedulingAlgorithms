# AccessSchedulingAlgorithms
First project for operating systems.

Program ma symulować działanie algorytmów planowania dostępu do procesora dla zgłaszających się procesów. Zbadać
średni czas oczekiwania procesów dla różnych algorytmów planowania:
1. FCFS
2. SJF (bez wywłaszczania)
3. SRTF (SJF z wywłaszczaniem)
4. rotacyjnego (z możliwością wyboru kwantu czasu)

Należy samodzielnie sformułować założenia symulacji.
Wskazówki:  
• Algorytmy należy sprawdzać dla tych samych danych testowych (tj. tych samych ciągów zgłaszających się procesów)  
• Ciągów testowych powinno być więcej (20? 50?); wynikiem będą wartości średnie.  
• W każdym ciągu będzie N procesów o losowych długościach fazy procesora (rozkład długości faz dobrać tak, by odpowiadał
sytuacji w rzeczywistym systemie, w którym nie jest równomierny), zgłaszających się w losowych momentach (dobrać
parametry tak, by mogła powstać kolejka procesów oczekujących na przydział procesora).  
• Możliwa reprezentacja procesu: klasa (numer, długość fazy procesora, moment zgłoszenia się, czas oczekiwania
/początkowo równy 0/...) 
