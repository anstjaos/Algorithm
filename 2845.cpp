#include <iostream>
using namespace std;

int L, P;

int main()
{
	cin >> L >> P;
	int temp;
	for (int i = 0; i < 5; i++)
	{
		cin >> temp;
		cout << temp - (L*P) << " ";
	}

	cout << endl;
	return 0;
}