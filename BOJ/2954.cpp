#include <iostream>
#include <string>
using namespace std;

string input;

int main()
{
	getline(cin, input);
	int size = input.size();

	for (int i = 0; i < size; i++)
	{
		cout << input[i];

		if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i'
			|| input[i] == 'o' || input[i] == 'u') i += 2;
	}
	
	cout << endl;
	return 0;
}