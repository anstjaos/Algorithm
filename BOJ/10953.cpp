#include <iostream>
#include <string>
using namespace std;

int testCase;
int result;
int main()
{
	cin >> testCase;
	cin.ignore();
	for (int i = 0; i < testCase; i++)
	{
		result = 0;
		string temp;
		getline(cin, temp, ',');
		result = result + stoi(temp);
		getline(cin, temp);
		result = result + stoi(temp);
		cout << result << endl;
	}
}