#include <iostream>
using namespace std;

int main()
{
	int a, b, people = 0, max = 0;

	for (int i = 0; i < 4; i++)
	{
		cin >> a >> b;
		people = people - a + b;
		if (people > max) max = people;
	}
	cout << max << endl;
	return 0;
}