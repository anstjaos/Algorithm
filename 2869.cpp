#include <iostream>
using namespace std;

int main()
{
	int A, B, V;

	cin >> A >> B >> V;

	int result = 0;

	if ((V - A) % (A - B) > 0) result = (V - A) / (A - B) + 2;
	else if ((V - A) % (A - B) == 0) result = (V - A) / (A - B) + 1;
	
	cout << result << '\n';
	return 0;
}