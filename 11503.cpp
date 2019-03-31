#include <iostream>
#include <string>
#include <stack>
#include <queue>
using namespace std;

typedef struct a{
	char label;
	a* child;
	a* sibling;

	a() {}
	a(char i_label)
	{
		label = i_label;
	}
}node;

int tc;
char input[10001];
node* tree;
node* tree1;

void initTree(node* &t)
{
	stack<node*> s;

	node* cur = NULL;
	node* parent = NULL;
	for (int i = 1; i < 10001; i++)
	{
		if (!input[i+1]) break;

		if (input[i] == '(')
		{
			s.push(cur);
		}
		else if (input[i] == ')')
		{
			parent = s.top();
			s.pop();
			cur->sibling = parent->child;
			parent->child = cur;
			cur = parent;
		}
		else cur = new node(input[i]);
	}
	t = cur;
}

void deleteTree(node* t)
{
	queue<node*> q;
	q.push(t);

	node* cur = NULL;
	node* temp = NULL;
	while (!q.empty())
	{
		cur = q.front();
		q.pop();

		temp = cur->child;
		while (temp == NULL)
		{
			q.push(temp);
			temp = temp->sibling;
		}
		delete cur;
	}
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%s", &input);
		initTree(tree);
		scanf("%s", &input);
		initTree(tree1);

		deleteTree(tree);
		deleteTree(tree1);
	}
}