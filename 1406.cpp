#include <iostream>
using namespace std;

char input[100001], order, alpha;
int cnt;

typedef struct a{
	char data;
	a* left;
	a* right;

	a() {}
	a(char i_data, a* i_left, a* i_right)
	{
		data = i_data;
		left = i_left;
		right = i_right;
	}
}word;

word* first;
word* cursor;

int strlen1(char *input)
{
	int cnt = 0;

	while (input[cnt] != '\0') cnt++;

	return cnt;
}

void pushWord(char input)
{
	cursor->right = new word(input, cursor, cursor->right);
	cursor = cursor->right;
	if(cursor->right !=0) cursor->right->left = cursor;
}

void initWord(char input)
{
	if (cursor == 0) first->right = cursor = new word(input, first, 0);
	else
	{
		cursor->right = new word(input, cursor, cursor->right);
		cursor = cursor->right;
	}
}

void moveLeft()
{
	if (cursor->left == 0) return;
	
	cursor = cursor->left;
}

void moveRight()
{
	if (cursor->right == 0) return;

	cursor = cursor->right;
}

void deleteCursor()
{
	if (cursor == first) return;
	else
	{
		cursor->left->right = cursor->right;
		if(cursor->right !=0) cursor->right->left = cursor->left;
		
		word* temp = cursor;

		cursor = cursor->left;
		delete temp;
	}
}

void showInput()
{
	cursor = first->right;

	while (cursor != 0)
	{
		cout << cursor->data;
		cursor = cursor->right;
	}
	cout << '\n';
}

void deleteInput()
{
	cursor = first;
	while (cursor != 0)
	{
		word* temp = cursor;
		cursor = cursor->right;
		delete temp;
	}
}
int main()
{
	first = new word(0, 0, 0);
	cin >> input;
	int leng = strlen1(input);

	for (int i = 0; i < leng; i++) initWord(input[i]);

	cin >> cnt;

	for (int i = 0; i < cnt; i++)
	{
		cin >> order;

		if (order == 'L')
		{
			moveLeft();
		}
		else if (order == 'D')
		{
			moveRight();
		}
		else if (order == 'B')
		{
			deleteCursor();
		}
		else if (order == 'P')
		{
			cin >> alpha;
			pushWord(alpha);
		}
	}

	showInput();
	deleteInput();
}