# IBM 6112884 Japanese layout with Alps switches
# The CPU was removed from the controller board and replaced with a Teensy, but the 4 to 16 line decoder remains (hence using muxstrobe).
# http://deskthority.net/post114200.html#p114200
# HaaTa's pics of similar keyboard: http://deskthority.net/post87127.html#p87127

#muxstrobe 10 3b changed from back_quote to backspace
#muxstrobe 7 19 changed from App to RGUI
#muxstrobe 0 08 changed from esc to page_down
#muxstrobe 12 5D changed from backspace to back_quote
#muxstrobe 10 2a changed from international_1 (ro, also scancode 073, the Japanese key next to rshift) to rshift so I now have two rshifts
#muxstrobe 2 19 and 5 19 are useless cannot be assigned


matrix
	scanrate 1
	debounce 5
	blocking 0
	muxstrobe_port PF7:4

	#				0			1			2				3			4			5				6			7
	#				8			9			A				B			C			D				E			F

	sense			PB3			PB7			PD0				PD1			PD2			PD3				PC6			PC7
	# 0
	muxstrobe 0		ESC			TAB			Z				S			W			2				UNASSIGNED	UNASSIGNED	
	muxstrobe 1		1			Q			X				D			E			3				UNASSIGNED	UNASSIGNED	
	# 1
	muxstrobe 2		CAPS_LOCK	unassigned	C				F			R			4				UNASSIGNED	UNASSIGNED	
	muxstrobe 3		A			LSHIFT		V				G			T			5				UNASSIGNED	UNASSIGNED	
	# 2
	muxstrobe 4		LCTRL		LGUI		B				H			Y			6				UNASSIGNED	UNASSIGNED	
	muxstrobe 5		LALT		unassigned	N				J			U			7				UNASSIGNED	UNASSIGNED	
	# 3
	muxstrobe 6		DOWN		SPACE		M				K			I			8				UNASSIGNED	UNASSIGNED	
	muxstrobe 7		RALT		rgui			COMMA			L			O			9				UNASSIGNED	UNASSIGNED	
	# 4
	muxstrobe 8		RCTRL		LEFT		PERIOD			SEMICOLON	P			0				UNASSIGNED	UNASSIGNED	
	muxstrobe 9		RIGHT		PAD_1		slash			QUOTE		LEFT_BRACE	MINUS			UNASSIGNED	UNASSIGNED	
	# 5				v PAD_ENTER top  v mod 00
	muxstrobe 10	PAD_ENTER	PAD_0	back_quote	ENTER	RIGHT_BRACE	EQUAL			UNASSIGNED	UNASSIGNED	
	muxstrobe 11	PAD_3		PAD_6		RSHIFT			ENTER		BACKSLASH	BACKSPACE	UNASSIGNED	UNASSIGNED	
	# 6
	muxstrobe 12	PAD_2		PAD_5		f11		f10	f15	backspace		EQUAL	EXTRA_PAD_PLUS	
	muxstrobe 13	PAD_ASTERIX	PAD_9		f13		PAD_4		PAD_8		PAD_SLASH		END			f14	
	# 7										^ orig PAD_1
	muxstrobe 14	PAD_MINUS	PAD_PLUS	UP				DELETE		PAD_7		NUM_LOCK		INSERT		PRINTSCREEN	
	muxstrobe 15	BACKSPACE	PAD_PERIOD	f12		PAGE_DOWN	PAGE_UP		PAUSE			HOME		SCROLL_LOCK	
	#										^ orig PAD_3
end

# need to map the FN key into the base layer (0)

remapblock
	layer 0
		RCTRL FN1
endblock

layerblock
		FN1	1
endblock

remapblock
	layer 1
		SCROLL_LOCK			MEDIA_VOLUME_DOWN 
		PRINTSCREEN			MEDIA_MUTE 
		PAUSE				MEDIA_VOLUME_UP 
		1					F1
		2					F2
		3					F3
		4					F4
		5					F5
		6					F6
		7					F7
		8					F8
		9					F9
		0					F10
		MINUS				F11
		EQUAL				F12
endblock



macroblock

macro F13
	PUSH_META CLEAR_META all		
	SET_META ctrl			
	PRESS C				
	PRESS T				
	PRESS V				
	POP_META			
	PRESS ENTER			
	POP_ALL_META			
endmacro

macro f14
	PUSH_META CLEAR_META all		
	SET_META ctrl		
	PRESS z				
	POP_META			
	POP_ALL_META
endmacro


macro f15
	PUSH_META CLEAR_META all		
	SET_META ctrl			
	PRESS x				
	POP_META			
	POP_ALL_META
endmacro

macro f10
	PUSH_META CLEAR_META all		
	SET_META ctrl			
	PRESS c				
	POP_META			
	POP_ALL_META
endmacro

macro f11
	PUSH_META CLEAR_META all		
	SET_META ctrl			
	PRESS v				
	POP_META			
	POP_ALL_META
endmacro

macro EXTRA_PAD_PLUS
	PRESS 0
	DELAY 10
	PRESS 0
endmacro

macro SLASH ctrl
	PRESS MEDIA_CALCULATOR		
endmacro


endblock



