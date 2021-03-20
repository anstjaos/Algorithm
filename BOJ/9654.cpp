#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	cout.setf(ios::left);
	cout << setw(15) << "SHIP NAME";
	cout << setw(15) << "CLASS";
	cout << setw(11) << "DEPLOYMENT";
	cout << setw(10) << "IN SERVICE" << endl;
	cout << setw(15) << "N2 Bomber";
	cout << setw(15) << "Heavy Fighter";
	cout << setw(11) << "Limited";
	cout << setw(10) << "21" << endl;
	cout << setw(15) << "J-Type 327";
	cout << setw(15) << "Light Combat";
	cout << setw(11) << "Unlimited";
	cout << setw(10) << "1" << endl;
	cout << setw(15) << "NX Cruiser";
	cout << setw(15) << "Medium Fighter";
	cout << setw(11) << "Limited";
	cout << setw(10) << "18" << endl;
	cout << setw(15) << "N1 Starfighter";
	cout << setw(15) << "Medium Fighter";
	cout << setw(11) << "Unlimited";
	cout << setw(10) << "25" << endl;
	cout << setw(15) << "Royal Cruiser";
	cout << setw(15) << "Light Combat";
	cout << setw(11) << "Limited";
	cout << setw(10) << "4" << endl;

}